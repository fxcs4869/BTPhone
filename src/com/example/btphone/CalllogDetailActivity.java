package com.example.btphone;

import java.util.ArrayList;

import com.example.btphone.adpter.CalllogDetailListAdapter;
import com.example.btphone.bean.CallInfo;
import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.PhoneBluth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class CalllogDetailActivity extends Activity {
	private Context mContext;
	private TextView tvName;
	private TextView tvNumber;
	private ListView lvCallList;
	private String name;
	private String number;
	private SQLiteDatabase CallLogdb;
	private ArrayList<CallInfo> CallList = new ArrayList<CallInfo>();
	private CalllogDetailListAdapter mAdapter;
	private String TAG="CalllogDetailActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calllog_detail);
		mContext = this;
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		name = bundle.getString("name");
		number = bundle.getString("number");

		/*
		 * Intent intent2 = new Intent( ��ʱ����
		 * "Wedesign.action.ACTION_MENU_VISIBLE");
		 * mContext.sendBroadcast(intent2);
		 */
	}

	@Override
	protected void onResume() {

		CallLogdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
		BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab);

		initView();
		initData();
		super.onResume();
	}

	private void initView() {
		tvName = (TextView) findViewById(R.id.call_name);
		tvNumber = (TextView) findViewById(R.id.call_number);
		lvCallList = (ListView) findViewById(R.id.each_caller_list);
		tvName.setText(name);
		tvNumber.setText(number);

	}

	private void initData() {
		String time;
		int type;

		if (name == null) {
			name = number;
		}
		Cursor cursor = CallLogdb.query("calllog", new String[] { "time", "calltype" }, "phonename=?", new String[] { name }, null, null, "time desc"); // "ORDEY BY ASC"
        if(cursor==null){
        	Log.d(TAG,"cursor==null");
        }
		while (cursor.moveToNext()) {
			time = cursor.getString(cursor.getColumnIndex("time"));
			type = cursor.getInt(cursor.getColumnIndex("calltype"));
			CallInfo callLog = new CallInfo();
			callLog.setDate(time);
			Log.d(TAG,"time="+time+"  type="+type);
			callLog.setCallType(type);
			CallList.add(callLog);
		}
		updataAdapter();

	}

	public void updataAdapter() {
		Log.d(TAG,"updataAdapter()");
		// TODO Auto-generated method stub
		if (mAdapter == null) {
			Log.d(TAG,"mAdapter == null");
			mAdapter = new CalllogDetailListAdapter(mContext);
			//lvCallList.setAdapter(mAdapter);
		}
		Log.d(TAG,"CallList.size() ="+CallList.size());
		if (CallList != null && CallList.size() != 0) {
			mAdapter.setData(CallList);
		}
		lvCallList.setAdapter(mAdapter);
	}

}