package com.example.btphone;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import com.example.btphone.adpter.CallListAdapter;
import com.example.btphone.bean.CallInfo;
import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.PhoneBluth;
import com.nforetek.bt.res.NfDef;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class CalllogActivity extends Activity {  

	private static String TAG = "CalllogActivity";

	private Button download;
	private Button back;
	private ListView listview;
	private ArrayAdapter<String> arrayAdapter;
	private static Context mContext;
	public static String lastCallNumber = null;
	private PhoneBluth phonebluth = null;
	private SQLiteDatabase CallLogdb; // 通话记录的数据库
	private SQLiteDatabase mDbDataBase;
	private ArrayList<CallInfo> CallList = new ArrayList<CallInfo>(); // 处理后的通话记录，同一个人的的汇总在一起
	private ArrayList<CallInfo> ShowCallList = new ArrayList<CallInfo>(); // 这是啥用？
	private HashSet<String> CallSet = new HashSet<String>(); // 这是啥用
	private CallListAdapter mAdapter;
	public static final int HANDLER_EVENT_ADD_VCARD_TO_BY_PASS_LIST = 9; //下载一条通话记录
	public static final int HANDLER_EVENT_DIAL = 10;// 在通话记录界面拨打电话
	public static final int HANDLER_DOWNLOAD_CALLLOG_DONE=11; //下载通话记录结束

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calllog);
		Log.e(TAG, "+++ ON CREATE +++");
		arrayAdapter = new ArrayAdapter<String>(this, R.layout.device_name);
		hand = mHandler;
		mContext = this;
		initView();
		phonebluth = PhoneBluth.getInstance(getApplicationContext());// 初始化PhoneBluth
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.e(TAG, "++ ON START ++");
	}

	@Override
	public synchronized void onResume() {
		super.onResume();
		Log.e(TAG, "--ON RESUME--");
		CallLogdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr); //获取数据库
		BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab);  //创建表
		mDbDataBase = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);//？获取数据库
		initData();
		updataAdapter();
	}

	@Override
	public synchronized void onPause() {
		super.onPause();
		Log.e(TAG, "- ON PAUSE -");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.e(TAG, "-- ON STOP --");
	}

	/*
	 * @Override public void onDestroy() { try {
	 * mCommand.unregisterPbapCallback(mCallbackPbap); } catch (RemoteException
	 * e) { e.printStackTrace(); } unbindService(mConnection);
	 * 
	 * mHandler = null; Log.v(TAG, "--- ON DESTROY ---"); super.onDestroy(); }
	 */
	public static Handler hand = null;

	public static Handler getHandler() {
		return hand;
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			switch (msg.what) {
			case HANDLER_EVENT_ADD_VCARD_TO_BY_PASS_LIST: // 每下载一条通话记录
				int type = bundle.getInt("TYPE");
				String name = bundle.getString("NAME");
				String time = bundle.getString("TIME");
				time=time.replace("T","");//去掉时间中的T,例如原时间为  20170227T143115
				String number = bundle.getString("NUMBER");
				CallInfo info = new CallInfo();
				/* info.setDate(TimestamptoDate(0 + "")); */
				info.setDate(time);
				info.setPhoneNum(number);
				info.setCallType(type);
				info.setName(name);
				addCallInfo(info);
				break;
			case HANDLER_DOWNLOAD_CALLLOG_DONE: // 下载通话记录结束
				Log.d(TAG, "HANDLER_DOWNLOAD_CALLLOG_DONE");
				updataAdapter();
				
				break;
			case HANDLER_EVENT_DIAL: // 在通话记录界面拨打电话
				String number2 = (String) msg.obj;
				if (phonebluth != null)
					phonebluth.reqHfpDialCall(number2);
				break;
			}
		}
	};

	private void initView() {
		download = (Button) findViewById(R.id.download);
		listview = (ListView) findViewById(R.id.listview);
		back = (Button) findViewById(R.id.back);

		download.setOnClickListener(new OnClickListener() { // 点击下载通话记录
			@Override
			public void onClick(View v) {
				Log.v(TAG, "download onClicked");
				if (CallList.size() != 0) { // 下载的前清除
					CallList.clear();
					CallSet.clear();
				}
				// ShowDownloadingDlg(); 显示下载对话框，暂时关闭

				BtPhoneDB.delete_table_data(CallLogdb, BtPhoneDB.CallLogTable); // 删除表数据
				BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab); // 创建表

				try {
					phonebluth.reqPbapDownload(NfDef.PBAP_STORAGE_CALL_LOGS);
					// type = NfDef.PBAP_STORAGE_CALL_LOGS;
					// setTitleSource("Combine CallLog");
					// enableButton(false);
				} catch (Exception e) {
					e.printStackTrace();
					// enableButton(true);
				}
			}

		});
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_back onClicked");
				Intent myIntent = new Intent();
				myIntent = new Intent(CalllogActivity.this, DialActivity.class);
				startActivity(myIntent);
			}
		});

		listview.setOnItemClickListener(new OnItemClickListener() {  //点击具体item查看详细通话记录
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.d(TAG, "listview onItemClick");
				if (ShowCallList.size() == 0)
					return;
				CallInfo info = ShowCallList.get(position);
				Intent intent = new Intent(CalllogActivity.this, CalllogDetailActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				startActivity(intent);

			}
		});
	}

	public String TimestamptoDate(String time) { // 时间转换工具,以后再研究吧

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String re_StrTime = "未知";
		long lcc_time = Long.valueOf(time);
		if (lcc_time == 0) {
			return re_StrTime;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date curDate = new Date(System.currentTimeMillis());
		String today = formatter.format(curDate);

		SimpleDateFormat sfd = new SimpleDateFormat("MM/dd,hh:mm");
		re_StrTime = sfd.format(lcc_time);

		if (today.equals(formatter.format(lcc_time))) {
			SimpleDateFormat sfd1 = new SimpleDateFormat("今天,hh:mm");
			re_StrTime = sfd1.format(lcc_time);
		}
		return re_StrTime;

	}

	private void addCallInfo(CallInfo info) {
		Log.d(TAG, "addCallInfo(CallInfo info)");
		String peoplename;
		try {
			peoplename = BtPhoneDB.queryPhoneName(mDbDataBase, BtPhoneDB.PhoneBookTable, info.getPhoneNum());
		} catch (Exception e) {
			peoplename = info.getPhoneNum();
		}

		if (peoplename == null) {
			peoplename = info.getPhoneNum();
		}

		info.setName(peoplename);

		for (int i = 0; i < CallList.size(); i++) {
			CallInfo tmp = CallList.get(i);
			if (tmp.getPhoneNum() == info.getPhoneNum()) {
				CallList.remove(i);
				break;
			}
		}

		CallList.add(info);
		CallSet.add(info.getPhoneNum());
		//updataAdapter();  不用添加一条记录就更新一次通话记录吧,去掉它
		Log.v(TAG, "info.getCallType()=" + info.getCallType() + "    info.getDate()=" + info.getDate());
		if (CallLogdb != null) {
			BtPhoneDB.insert_calllog(CallLogdb, BtPhoneDB.CallLogTable, info.getName(), info.getPhoneNum(), info.getCallType(), info.getDate());
		} else {
			CallLogdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
			BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab);
			BtPhoneDB.insert_calllog(CallLogdb, BtPhoneDB.CallLogTable, info.getName(), info.getPhoneNum(), info.getCallType(), info.getDate());
			if (CallLogdb != null) {
				CallLogdb.close(); // close database
				CallLogdb = null;
			}
		}

	}

	public void updataAdapter() {
		Log.d(TAG, "updataAdapter");
		if (mAdapter == null) {
			mAdapter = new CallListAdapter(mContext, mHandler);
			// mListWithScrollBarView.getListView().setAdapter(mAdapter);
		}
		// mListWithScrollBarView.getListView().removeViews(0,
		// mListWithScrollBarView.getListView().getChildCount());
		lastCallNumber = null;
		ShowCallList = new ArrayList<CallInfo>();

		CallInfo callInfo1 = null;
		String tmpString1 = null;
		String tmpString2 = null;
		CallInfo callInfo2 = null;
		boolean haveChange = false;

		ArrayList<CallInfo> tmp = new ArrayList<CallInfo>(CallList);
		Log.d(TAG, "CallList.size()="+CallList.size());

        
		if (tmp.size() != 0) {

			for (; tmp.size() > 0;) {

				callInfo1 = tmp.get(0);
				int i;
				haveChange = false;

				for (i = 0; i < tmp.size(); i++) {
					callInfo2 = tmp.get(i);
					if (callInfo1.getCalltime() < callInfo2.getCalltime()) {
						callInfo1 = callInfo2;
						haveChange = true;
					}
				}

				if (haveChange)
					tmp.remove(i - 1);
				else
					tmp.remove(0);
				if ((lastCallNumber == null) && (callInfo1.getCalltime() > 0))
					lastCallNumber = new String(callInfo1.getPhoneNum());
				ShowCallList.add(callInfo1);
				for (i = 0; i < tmp.size();) {
					if (tmp.get(i).getPhoneNum().equals(callInfo1.getPhoneNum())) {
						tmp.remove(i);
					} else
						i++;
				}
			}
		}

		if (ShowCallList != null && ShowCallList.size() != 0) {
			mAdapter.setData(ShowCallList);
			// mListWithScrollBarView.setMaxProgress(ShowCallList.size());//
			// �˲�������õĻ���������setAdapterǰִ��
			listview.setAdapter(mAdapter);
			// mListWithScrollBarView.hideWarn();
			Log.d(TAG, "notifyDataSetChanged");
			mAdapter.notifyDataSetChanged();
		} else {
			// mListWithScrollBarView.setWarnShow();
		}
	}

	private void initData() {
		// TODO Auto-generated method stub
		// asyncQueryHandler.startQuery(0, null, uri, projection, null, null,
		// CallLog.Calls.DEFAULT_SORT_ORDER);
		Log.d(TAG, "initData()");
		String Phonename;
		String Phonenum;
		String time;
		int type;

		
		CallList.clear(); //因为初始化数据了，将这两个都清空
		CallSet.clear();
		// 增加分组
		String groupBy = "phonename";

		Cursor cursor = CallLogdb.query("calllog", new String[] { "phonename", "phonenumber", "time", "calltype" }, null, null, null, null, "time desc"); // "ORDEY BY ASC"

		while (cursor.moveToNext()) {
			Phonenum = cursor.getString(cursor.getColumnIndex("phonenumber"));
			Phonename = cursor.getString(cursor.getColumnIndex("phonename"));
			time = cursor.getString(cursor.getColumnIndex("time"));
			type = cursor.getInt(cursor.getColumnIndex("calltype"));
			CallInfo callLog = new CallInfo();
			callLog.setName(Phonename);
			callLog.setPhoneNum(Phonenum);
			callLog.setDate(time);
			callLog.setCallType(type);
			// callLog.setCalltime(Long.parseLong(time.trim()));
			CallList.add(callLog);
			CallSet.add(callLog.getPhoneNum());
		}
	}

}
