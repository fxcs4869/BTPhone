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
	private ImageButton btnCallDial;
	private LinearLayout btnPhoneInfo;
	private LinearLayout btnDialpad;
	private TextView mDtmDigits = null;

	private String number;
	private boolean isIncoming = false; // �Ƿ������� trueΪ����
										// falseΪȥ�磬ֻ���ڲ��ӵ绰����ͬ��ͨ�����ͣ�
	private boolean isFinish = false;
	private boolean hangUp = false;
	private int callType = 5; // ͨ������ δ��5 ����6 ȥ��7 ֻ����ͨ����¼����ͬ��绰���ͣ�
	private SQLiteDatabase mDbDataBase;
	private String peoplename;
	private boolean touchCallIn = false;
	private boolean mShowCallDial = false;
	private boolean havaChangeSound = false;
	private static final HashMap<Integer, Character> mDisplayMap = new HashMap<Integer, Character>();
	private String mMTPData = null;
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
		isIncoming = bundle.getBoolean("isIncoming"); // ����
		initView();
		initData();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "++onResume()++");
		Settings.System.putInt(getContentResolver(), "status_bar_disabled", 1); // ����ɶ��
		isFinish = false;
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
		chronomter.setVisibility(View.INVISIBLE); // ��ʱ����Ϊ���ɼ�
		btnCallin = (ImageButton) findViewById(R.id.callin); // ��������
		btnHandup = (ImageButton) findViewById(R.id.handup); // �Ҷ�
		btnBtDevice = (ImageButton) findViewById(R.id.callBtDevice); // ��������
		btnBtPhone = (ImageButton) findViewById(R.id.callBtPhone); // �ֻ�����
		btnCallDial = (ImageButton) findViewById(R.id.callDial); // �绰ȡ��
		mDtmDigits = (TextView) findViewById(R.id.digits); // ��ʾ�������������
		btnPhoneInfo = (LinearLayout) findViewById(R.id.phoneInfo);
		btnDialpad = (LinearLayout) findViewById(R.id.dialpad_img);

		btnHandup.setOnClickListener(this);
		btnCallin.setOnClickListener(this);
		btnBtDevice.setOnClickListener(this);
		btnBtPhone.setOnClickListener(this);
		btnCallDial.setOnClickListener(this);

		if (isIncoming) { // ���������
			btnCallin.setVisibility(View.VISIBLE);
			btnHandup.setVisibility(View.VISIBLE);
			btnCallDial.setVisibility(View.GONE);

		} else { // ����Ϊȥ��
			btnCallin.setVisibility(View.GONE);
			btnHandup.setVisibility(View.VISIBLE);
			btnCallDial.setVisibility(View.VISIBLE);
		}
		chronomter.setVisibility(View.VISIBLE);
		// chronomter.setBase(SystemClock.elapsedRealtime() - (time + 1) *1000);
		chronomter.setBase(SystemClock.elapsedRealtime() - 1000);// ?
		chronomter.start();
		btnBtDevice.setVisibility(View.VISIBLE);
		btnBtPhone.setVisibility(View.GONE);

	}

	private void initData() {
		hand = handler;
		phonebluth = PhoneBluth.getInstance(getApplicationContext()); // ��ʼ��phonebluth
		mDbDataBase = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);// �������ݿ�
		BtPhoneDB.createTable(mDbDataBase, BtPhoneDB.Sql_create_calllog_tab); // ������
		peoplename = BtPhoneDB.queryPhoneName(mDbDataBase, BtPhoneDB.PhoneBookTable, number);
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
			if (isIncoming) { // ���Ϊ����
				callType = 6;
			}
			break;

		case R.id.callin: {
			touchCallIn = true;
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
		case R.id.callDial: {
			mShowCallDial = mShowCallDial ? false : true;
			if (mShowCallDial) {
				btnPhoneInfo.setVisibility(View.GONE);
				btnDialpad.setVisibility(View.VISIBLE);
				setupKeypad();
			} else {
				btnPhoneInfo.setVisibility(View.VISIBLE);
				btnDialpad.setVisibility(View.GONE);
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
				case MSG_TALKING: { // ��ͨ
					Log.v(TAG, "MSG_TALKING");
					chronomter.setBase(SystemClock.elapsedRealtime()); // �ӿ��������ڵĺ��������ֻ�˯��(sleep)��ʱ��Ҳ�������ڣ�
					chronomter.setVisibility(View.VISIBLE);// Chronometr��һ���򵥵Ķ�ʱ��
					chronomter.start();
					btnCallin.setVisibility(View.GONE);
					btnHandup.setVisibility(View.VISIBLE);
					Log.v(TAG, "phoneBegin in MSG_TALKING");
				}
					break;
				case MSG_HANGUP: { // �Ҷ�
					Log.v(TAG, "case MSG_HANGUP");
					addCallLog();
					finishThisActivity(true);
				}

					break;
				case MSG_HFP_LOCAL: { // ������Ƶ���ֻ���Ͳ
					Log.d(TAG, "MSG_HFP_LOCAL  �����������ֻ���Ͳ");
					handler.sendEmptyMessageDelayed(MSG_DEAL_DELAY, 100);
					if ((isIncoming) && (!havaChangeSound)) {
						if (touchCallIn) {
							Log.d(TAG, "phonebluth.reqHfpAudioTransferToCarkit();");
							touchCallIn = false;
							phonebluth.reqHfpAudioTransferToPhone();
						}
					}
					havaChangeSound = true;

				}
					break;
				case MSG_DEAL_DELAY: {
					Log.d(TAG, "MSG_DEAL_DELAY");
					if (!hangUp) {
						Log.d(TAG, "btnBtPhone.setVisibility(View.VISIBLE);");
						btnBtDevice.setVisibility(View.GONE);
						btnBtPhone.setVisibility(View.VISIBLE);
					} else {
						finishThisActivity(true);
						return;
					}

				}
					break;
				case MSG_HFP_REMOTE: {
					btnBtDevice.setVisibility(View.VISIBLE);
					btnBtPhone.setVisibility(View.GONE);
					if ((isIncoming) && (!havaChangeSound)) {
						if (!touchCallIn) {
							Log.d(TAG, "service.phoneTransfer();");
							touchCallIn = false;
							phonebluth.reqHfpAudioTransferToCarkit();
						}
					}
					havaChangeSound = true;
				}
					break;
				}

			}
		}
	};

	private void addCallLog() { // �������ͨ����¼�����ݿ�
		Log.d(TAG, "addCallLog()");
		if (mDbDataBase != null) {
			Date nowTime = new Date(System.currentTimeMillis());
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");// System.currentTimeMillis()
																					// �õ�����1970�������ĺ�����
			String retStrFormatNowDate = sdFormatter.format(nowTime);
			Log.v(TAG, "peoplename=" + peoplename + "  number=" + number + " callType=" + callType + "date=" + retStrFormatNowDate);
			BtPhoneDB.insert_calllog(mDbDataBase, BtPhoneDB.CallLogTable, peoplename, number, callType, retStrFormatNowDate);
		}
	}

	private void finishThisActivity(boolean wantFinish) { // ����activity�ķ���
		Log.d(TAG, "finishThisActivity " + isFinish + "  1");
		if (!isFinish) {
			isFinish = true;
			if (wantFinish) {
				finish();
				// System.exit(0);
				// //408�����������绰���ں�̨ʱ�绰������CallActivityɱ������˸�ΪSystem.exit(0);
			}
		}
	}

	private void setupKeypad() {
		// for each view id listed in the displaymap
		View button;
		for (int viewId : mDisplayMap.keySet()) {
			// locate the view
			button = findViewById(viewId);
			// Setup the listeners for the buttons
			// button.setOnTouchListener(this);
			button.setClickable(true);
			// button.setOnKeyListener(this);
			// button.setOnHoverListener(this);
			button.setOnClickListener(this);
		}
	}

}
