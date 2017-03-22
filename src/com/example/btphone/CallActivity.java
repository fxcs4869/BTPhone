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
	private boolean isIncoming = false; // 是否是来电 true为来电
										// false为去电，只用于拨接电话（不同于通话类型）
	private boolean isFinish = false;
	private boolean hangUp = false;
	private int callType = 5; // 通话类型 未接5 来电6 去电7 只用于通话记录（不同与电话类型）
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
	public static final int MSG_TALKING = 8; // 接通
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
		number = bundle.getString("number"); // 通话号码
		isIncoming = bundle.getBoolean("isIncoming"); // 类型
		initView();
		initData();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "++onResume()++");
		Settings.System.putInt(getContentResolver(), "status_bar_disabled", 1); // 这是啥？
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
		tvNumber = (TextView) findViewById(R.id.callNumber); // 号码
		tvName = (TextView) findViewById(R.id.callName); // 姓名
		chronomter = (Chronometer) findViewById(R.id.chronometer); // 计时器
		chronomter.setVisibility(View.INVISIBLE); // 计时器设为不可见
		btnCallin = (ImageButton) findViewById(R.id.callin); // 接听来电
		btnHandup = (ImageButton) findViewById(R.id.handup); // 挂断
		btnBtDevice = (ImageButton) findViewById(R.id.callBtDevice); // 车机声音
		btnBtPhone = (ImageButton) findViewById(R.id.callBtPhone); // 手机声音
		btnCallDial = (ImageButton) findViewById(R.id.callDial); // 电话取消
		mDtmDigits = (TextView) findViewById(R.id.digits); // 显示键盘输入的内容
		btnPhoneInfo = (LinearLayout) findViewById(R.id.phoneInfo);
		btnDialpad = (LinearLayout) findViewById(R.id.dialpad_img);

		btnHandup.setOnClickListener(this);
		btnCallin.setOnClickListener(this);
		btnBtDevice.setOnClickListener(this);
		btnBtPhone.setOnClickListener(this);
		btnCallDial.setOnClickListener(this);

		if (isIncoming) { // 如果是来电
			btnCallin.setVisibility(View.VISIBLE);
			btnHandup.setVisibility(View.VISIBLE);
			btnCallDial.setVisibility(View.GONE);

		} else { // 否则为去电
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
		phonebluth = PhoneBluth.getInstance(getApplicationContext()); // 初始化phonebluth
		mDbDataBase = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);// 创建数据库
		BtPhoneDB.createTable(mDbDataBase, BtPhoneDB.Sql_create_calllog_tab); // 创建表
		peoplename = BtPhoneDB.queryPhoneName(mDbDataBase, BtPhoneDB.PhoneBookTable, number);
		if (peoplename == null) { // 如果数据库中没有存该联系人，联系人的名字就用号码表示
			peoplename = number;
		}
		tvNumber.setText(number);
		tvName.setText(peoplename);
		callType = (isIncoming ? 6 : 7);// 如果电话类型为去电7,否则为来电6
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.handup:
			phonebluth.reqHfpTerminateCurrentCall(); // 结束当前通话
			if (isIncoming) { // 如果为来电
				callType = 6;
			}
			break;

		case R.id.callin: {
			touchCallIn = true;
			phonebluth.reqHfpAnswerCall(0); // 接听来电
		}
			break;
		case R.id.callBtPhone: {
			phonebluth.reqHfpAudioTransferToCarkit(); // 切换声道到车机
		}
			break;
		case R.id.callBtDevice: {
			Log.d(TAG, "callBtDevice clicked");
			phonebluth.reqHfpAudioTransferToPhone(); // 切换声道到手机

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
			phonebluth.reqHfpSendDtmf(mDisplayMap.get(v.getId()).toString());// 根据按键输出DTMF
			if (mMTPData == null)// 显示
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
				case MSG_TALKING: { // 接通
					Log.v(TAG, "MSG_TALKING");
					chronomter.setBase(SystemClock.elapsedRealtime()); // 从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
					chronomter.setVisibility(View.VISIBLE);// Chronometr是一个简单的定时器
					chronomter.start();
					btnCallin.setVisibility(View.GONE);
					btnHandup.setVisibility(View.VISIBLE);
					Log.v(TAG, "phoneBegin in MSG_TALKING");
				}
					break;
				case MSG_HANGUP: { // 挂断
					Log.v(TAG, "case MSG_HANGUP");
					addCallLog();
					finishThisActivity(true);
				}

					break;
				case MSG_HFP_LOCAL: { // 车机音频到手机听筒
					Log.d(TAG, "MSG_HFP_LOCAL  蓝牙车机到手机听筒");
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

	private void addCallLog() { // 添加这条通话记录到数据库
		Log.d(TAG, "addCallLog()");
		if (mDbDataBase != null) {
			Date nowTime = new Date(System.currentTimeMillis());
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");// System.currentTimeMillis()
																					// 得到的是1970年以来的毫秒数
			String retStrFormatNowDate = sdFormatter.format(nowTime);
			Log.v(TAG, "peoplename=" + peoplename + "  number=" + number + " callType=" + callType + "date=" + retStrFormatNowDate);
			BtPhoneDB.insert_calllog(mDbDataBase, BtPhoneDB.CallLogTable, peoplename, number, callType, retStrFormatNowDate);
		}
	}

	private void finishThisActivity(boolean wantFinish) { // 结束activity的方法
		Log.d(TAG, "finishThisActivity " + isFinish + "  1");
		if (!isFinish) {
			isFinish = true;
			if (wantFinish) {
				finish();
				// System.exit(0);
				// //408不能在蓝牙电话处于后台时电话结束后将CallActivity杀死，因此改为System.exit(0);
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
