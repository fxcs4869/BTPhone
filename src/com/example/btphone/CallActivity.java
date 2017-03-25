package com.example.btphone;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.PhoneBluth;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CallActivity extends Activity implements OnClickListener {
	private static String TAG = "CallActivity";
	PhoneBluth phonebluth = null;
	private TextView tvNumber;
	private TextView tvName;
	private Chronometer chronomter;
	private ImageButton btnHandup;
	private ImageButton btnCallin;
	private ImageButton btnBtDevice;
	private ImageButton btnBtPhone;
	private ImageButton btnDialpad;
	private LinearLayout phoneinfo_layout;
	private LinearLayout dialpad_layout;
	private TextView mDtmDigits = null;
	private String number;
	private boolean isIncoming = false; // �Ƿ�������
	private boolean hangUp = false;
	private boolean isTaking = false; // �Ƿ���ͨ�������еı�־λ
	private boolean mShowCallDial = false;// �Ƿ���ʾ��С���̵ı�־λ
	private int callType = 5; // ͨ������ δ��5 ����6 ȥ��7 ֻ����ͨ����¼����ͬ��绰���ͣ�
	private SQLiteDatabase mDbDataBase;
	private String peoplename;
	private static final HashMap<Integer, Character> mDisplayMap = new HashMap<Integer, Character>();
	private String mMTPData = null;// С������ʾ������
	public static final int MSG_HANGUP = 3;
	public static final int MSG_HFP_LOCAL = 4;
	public static final int MSG_HFP_REMOTE = 5;
	public static final int MSG_DEAL_DELAY = 6;
	public static final int MSG_COMMING = 7;
	public static final int MSG_TALKING = 8; // ��ͨ
	static {
		mDisplayMap.put(R.id.one, '1');
		mDisplayMap.put(R.id.two, '2');
		mDisplayMap.put(R.id.three, '3');
		mDisplayMap.put(R.id.four, '4');
		mDisplayMap.put(R.id.five, '5');
		mDisplayMap.put(R.id.six, '6');
		mDisplayMap.put(R.id.seven, '7');
		mDisplayMap.put(R.id.eight, '8');
		mDisplayMap.put(R.id.nine, '9');
		mDisplayMap.put(R.id.zero, '0');
		mDisplayMap.put(R.id.pound, '#');
		mDisplayMap.put(R.id.star, '*');
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		Log.e(TAG, "+++ ON CREATE +++");
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		number = bundle.getString("number"); // ͨ������
		isIncoming = bundle.getBoolean("isIncoming"); // �绰����
		initView();
		initData();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "++onResume()++");
		Settings.System.putInt(getContentResolver(), "status_bar_disabled", 1); // ����ɶ��
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG, "++onPause()++");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG, "++onStop()++");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "++onDestroy()++");
	}

	private void initView() {
		Log.d(TAG, " initView()");
		tvNumber = (TextView) findViewById(R.id.callNumber); // ����
		tvName = (TextView) findViewById(R.id.callName); // ����
		chronomter = (Chronometer) findViewById(R.id.chronometer); // ��ʱ��
		btnCallin = (ImageButton) findViewById(R.id.callin); // ��������
		btnHandup = (ImageButton) findViewById(R.id.handup); // �Ҷ�
		btnBtDevice = (ImageButton) findViewById(R.id.callBtDevice); // ��������
		btnBtPhone = (ImageButton) findViewById(R.id.callBtPhone); // �ֻ�����
		btnDialpad = (ImageButton) findViewById(R.id.keyboard); // ��С����
		mDtmDigits = (TextView) findViewById(R.id.digits); // ��ʾ�������������
		phoneinfo_layout = (LinearLayout) findViewById(R.id.phoneInfo);
		dialpad_layout = (LinearLayout) findViewById(R.id.dialpad_layout);

		btnHandup.setOnClickListener(this);
		btnCallin.setOnClickListener(this);
		btnBtDevice.setOnClickListener(this);
		btnBtPhone.setOnClickListener(this);
		btnDialpad.setOnClickListener(this);

		if (isIncoming) { // ���������
			btnCallin.setVisibility(View.VISIBLE);
			btnHandup.setVisibility(View.VISIBLE);
			btnDialpad.setVisibility(View.GONE);

		} else { // ����Ϊȥ��
			btnCallin.setVisibility(View.GONE);
			btnHandup.setVisibility(View.VISIBLE);
			btnDialpad.setVisibility(View.VISIBLE);
		}
		chronomter.setBase(SystemClock.elapsedRealtime());// ?
		chronomter.start();
		btnBtDevice.setVisibility(View.VISIBLE);
		btnBtPhone.setVisibility(View.GONE);

	}

	private void initData() {
		Log.d(TAG, "initData()");
		hand = handler;
		phonebluth = PhoneBluth.getInstance(getApplicationContext()); // ��ʼ��phonebluth
		mDbDataBase = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);// �������ݿ�
		//BtPhoneDB.createTable(mDbDataBase, BtPhoneDB.Sql_create_calllog_tab); // ������
		peoplename = BtPhoneDB.queryPhoneName(mDbDataBase, BtPhoneDB.PhoneBookTable, number);
		Log.d(TAG, "peoplename="+peoplename+"number="+number);
		if (peoplename == null) { // ������ݿ���û�д����ϵ�ˣ���ϵ�˵����־��ú����ʾ
			peoplename = number;
		}
		tvNumber.setText(number);
		tvName.setText(peoplename);
		callType = (isIncoming ? 6 : 7);// ����绰����Ϊȥ��7,����Ϊ����6
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.handup:
			phonebluth.reqHfpTerminateCurrentCall(); // ������ǰͨ��
			break;

		case R.id.callin: {
			phonebluth.reqHfpAnswerCall(0); // ��������
		}
			break;
		case R.id.callBtPhone: {
			phonebluth.reqHfpAudioTransferToCarkit(); // �л�����������
		}
			break;
		case R.id.callBtDevice: {
			Log.d(TAG, "callBtDevice clicked");
			phonebluth.reqHfpAudioTransferToPhone(); // �л��������ֻ�

		}
			break;
		case R.id.keyboard: {// ����С����
			mShowCallDial = mShowCallDial ? false : true;
			if (mShowCallDial) {
				phoneinfo_layout.setVisibility(View.GONE);
				dialpad_layout.setVisibility(View.VISIBLE);
				setupKeypad();// ��ʼ��С����
			} else {
				phoneinfo_layout.setVisibility(View.VISIBLE);
				dialpad_layout.setVisibility(View.GONE);
			}
		}
			break;
		default: {
			phonebluth.reqHfpSendDtmf(mDisplayMap.get(v.getId()).toString());// ���ݰ������DTMF
			if (mMTPData == null)// ��ʾ
			{
				mMTPData = "" + mDisplayMap.get(v.getId());
			} else {
				mMTPData = mMTPData + mDisplayMap.get(v.getId());
			}
			mDtmDigits.setText(mMTPData);
		}
			break;
		}
	}

	public static Handler hand = null;

	public static Handler getHandler() {

		synchronized (CallActivity.class) {
			return hand;
		}
	}

	Handler handler = new myHandler(this);

	class myHandler extends Handler {
		WeakReference<Activity> mActivityReference;

		myHandler(Activity activity) {
			mActivityReference = new WeakReference<Activity>(activity);
		}

		@Override
		public void handleMessage(android.os.Message msg) {
			final Activity activity = mActivityReference.get();
			if (activity != null) {
				switch (msg.what) {

				case MSG_TALKING: // ��ͨ
					Log.v(TAG, "MSG_TALKING");
					isTaking = true;// ��־λΪtrue;
					chronomter.setBase(SystemClock.elapsedRealtime()); // �ӿ��������ڵĺ��������ֻ�˯��(sleep)��ʱ��Ҳ�������ڣ�
					chronomter.start();
					btnCallin.setVisibility(View.GONE);
					btnHandup.setVisibility(View.VISIBLE);
					break;

				case MSG_HANGUP: // �Ҷ�
					Log.v(TAG, "case MSG_HANGUP");
					if (isIncoming) { // ���Ϊ����
						callType = (isTaking ? 6 : 5);
					}
					isTaking = false;// ��־λΪfalse;
					addCallLog();
					finishThisActivity(true);
					break;

				case MSG_HFP_LOCAL: // ������Ƶ���ֻ���Ͳ
					btnBtDevice.setVisibility(View.GONE);
					btnBtPhone.setVisibility(View.VISIBLE);
					break;

				case MSG_HFP_REMOTE:// �ֻ���Ͳ��������Ƶ
					btnBtDevice.setVisibility(View.VISIBLE);
					btnBtPhone.setVisibility(View.GONE);
					break;
				}

			}
		}
	};

	private void addCallLog() { // �������ͨ����¼�����ݿ�
		Log.d(TAG, "addCallLog()");
		if (mDbDataBase != null) {
			Date nowTime = new Date(System.currentTimeMillis());// �õ�����1970�������ĺ�����
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String retStrFormatNowDate = sdFormatter.format(nowTime);
			Log.v(TAG, "peoplename=" + peoplename + "  number=" + number + " callType=" + callType + "date=" + retStrFormatNowDate);
			BtPhoneDB.insert_calllog(mDbDataBase, BtPhoneDB.CallLogTable, peoplename, number, callType, retStrFormatNowDate);
		}
	}

	private void finishThisActivity(boolean wantFinish) { // ����activity�ķ���
		Log.d(TAG, "finishThisActivity ");
		if (wantFinish) {
			 finish();// ?�����������绰���ں�̨ʱ�绰������CallActivityɱ��
		}
	}

	private void setupKeypad() { // ��ʼ��С����
		// for each view id listed in the displaymap
		View button;
		for (int viewId : mDisplayMap.keySet()) {
			button = findViewById(viewId);
			button.setClickable(true);
			button.setOnClickListener(this);
		}
	}

}
