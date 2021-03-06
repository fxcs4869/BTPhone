package com.example.btphone;

import java.util.ArrayList;

import com.example.btphone.adpter.CallListAdapter;
import com.example.btphone.bean.CallInfo;
import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.MyApplication;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CalllogActivity extends Activity {

	private static String TAG = "CalllogActivity";

	private Button download; 
	private Button back;
	private ListView listview;
	private static Context mContext;
	public static String lastCallNumber = null;
	private PhoneBluth phonebluth = null;
	private SQLiteDatabase CallLogdb; // 通话记录的数据库
	private ArrayList<CallInfo> AllCalllogList = new ArrayList<CallInfo>(); // 所有的通话记录
	private ArrayList<CallInfo> showCalllogList = new ArrayList<CallInfo>(); // 处理后的通话记录，同一个人的的汇总在一起
	private CallListAdapter mAdapter;
	public static final int HANDLER_EVENT_ADD_VCARD_TO_BY_PASS_LIST = 9; // 下载一条通话记录
	public static final int HANDLER_EVENT_DIAL = 10;// 在通话记录界面拨打电话
	public static final int HANDLER_DOWNLOAD_CALLLOG_DONE = 12; // 下载通话记录结束

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calllog);
		Log.e(TAG, "+++ onCreate() +++");
		initView();
		hand = mHandler;
		mContext = this;
		phonebluth = PhoneBluth.getInstance(getApplicationContext());// 初始化PhoneBluth
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.e(TAG, "++ onStart() ++");
	}

	@Override
	public synchronized void onResume() {
		super.onResume();
		Log.e(TAG, "++onResume()++");
		initData();
	}

	@Override
	public synchronized void onPause() {
		super.onPause();
		Log.e(TAG, "- onPause() -");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.e(TAG, "--onStop()--");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (CallLogdb != null) {
			CallLogdb.close(); // close database
			CallLogdb = null;
		}
		super.onDestroy();
	}

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
				time = time.replace("T", "");// 去掉时间中的T,例如原时间为 20170227T143115
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
				AllCalllogList.clear();
				MyApplication.load_ContactsOrCalllog=false;
				BtPhoneDB.delete_table_data(CallLogdb, BtPhoneDB.CallLogTable); // 删除表数据
				try {
					phonebluth.reqPbapDownload(NfDef.PBAP_STORAGE_CALL_LOGS);
				} catch (Exception e) {
					e.printStackTrace();
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

		listview.setOnItemClickListener(new OnItemClickListener() { // 点击具体item查看详细通话记录

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Log.d(TAG, "listview onItemClick");
				if (showCalllogList.size() == 0)
					return;
				CallInfo info = showCalllogList.get(position);
				Intent intent = new Intent(CalllogActivity.this, CalllogDetailActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				startActivity(intent);

			}
		});
	}

	private void initData() { //从数据库中更新 因为通话记录数据量有限，应该无需用asyncQueryHandler
		// TODO Auto-generated method stub
		Log.d(TAG, "initData()");
		String Phonename;
		String Phonenum;
		String time;
		int type;
		CallLogdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr); // 获取数据库
		BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab); // 创建表
		AllCalllogList.clear();
		Cursor cursor = CallLogdb.query("calllog", new String[] { "phonename", "phonenumber", "time", "calltype" }, null, null, null, null, "time desc"); // "ORDEY BY ASC"
		Log.d(TAG, "cursor.getCount()="+cursor.getCount());
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
			AllCalllogList.add(callLog);
		}
		updataAdapter();
	}

	

	private void addCallInfo(CallInfo info) {
		
		Log.d(TAG, "addCallInfo(CallInfo info)");
		AllCalllogList.add(info);
		Log.v(TAG, "size=" + AllCalllogList.size()+"name=" + info.getName() + " num=" + info.getPhoneNum() + " Type=" + info.getCallType() + " Date=" + info.getDate());
			BtPhoneDB.insert_calllog(CallLogdb, BtPhoneDB.CallLogTable, info.getName(), info.getPhoneNum(), info.getCallType(), info.getDate());

	}

	public void updataAdapter() {
		Log.d(TAG, "updataAdapter");
		if (mAdapter == null) {
			mAdapter = new CallListAdapter(mContext, mHandler);
		}
		lastCallNumber = null;
		showCalllogList = new ArrayList<CallInfo>();

		CallInfo callInfo1 = null;
		CallInfo callInfo2 = null;
		boolean haveChange = false;

		ArrayList<CallInfo> tmp = new ArrayList<CallInfo>(AllCalllogList);
		Log.d(TAG, "AllCalllogList.size()=" + AllCalllogList.size());

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
				showCalllogList.add(callInfo1);
				for (i = 0; i < tmp.size();) {
					if (tmp.get(i).getPhoneNum().equals(callInfo1.getPhoneNum())) {
						tmp.remove(i);
					} else
						i++;
				}
			}
		}

		if (showCalllogList != null && showCalllogList.size() != 0) {
			mAdapter.setData(showCalllogList);
			listview.setAdapter(mAdapter);
			Log.d(TAG, "notifyDataSetChanged");
			mAdapter.notifyDataSetChanged();
		} else {
			// mListWithScrollBarView.setWarnShow();
		}
	}

}
