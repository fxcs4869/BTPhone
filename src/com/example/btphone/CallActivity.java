package com.example.btphone;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.PhoneBluth;
import com.nforetek.bt.aidl.UiCommand;
import com.nforetek.bt.res.NfDef;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends Activity implements OnClickListener {
	private static String TAG = "CallActivity";
	private Handler mHandler = null;
	PhoneBluth phonebluth = null;
	private TextView tvNumber;
	private TextView tvType;
	private TextView tvName;
	private Chronometer chronomter;
	private ImageButton btnHandup;
	private ImageButton btnCallin;
	private ImageButton btnBtDevice;
	private ImageButton btnBtPhone;
	private ImageButton btnCallDial;
	private LinearLayout btnPhoneInfo;
	private LinearLayout btnDialpad;
	private EditText mDtmDigits = null;

	private String number;
	private int time;
	private boolean bCAllIn = false; // 电话类型，只有2种，来电和去电，用boolean表示（不同于通话类型）
	private CallStatus bStatus;
	private boolean mIsInPhone = false;
	private boolean mVoideIndevice = false;

	private enum CallStatus {
		CALL_DEFUALT, CALL_STANDY, CALL_REVERSE, CALL_TALKING // 默认、待机、倒车、通话
	}

	private boolean soundInRemote = true;
	private boolean isConnect = false;
	private boolean isTaking = false; // 是否处于通话中
	private boolean isFinish = false;
	private boolean mMainActivityFinish = false;
	private boolean hangUp = false;
	private int callType = 5; // 通话类型 未接5 来电6 去电7 只用于通话记录
	private int nowSoundStatus = 0;
	private SQLiteDatabase CallLogdb;
	private SQLiteDatabase mDbDataBase;
	// private String name;
	private String peoplename;
	private boolean touchHangUp = false;
	private boolean touchCallIn = false;
	private boolean mShowCallDial = false;
	private boolean havaChangeSound = false;
	private static final HashMap<Integer, Character> mDisplayMap = new HashMap<Integer, Character>();
	private static final HashMap<Character, Integer> mDisplayDTMFMap = new HashMap<Character, Integer>();
	private static final HashMap<Integer, Integer> mKeyCodeMap = new HashMap<Integer, Integer>();
	private String mMTPData = null;
	public static final int MSG_HANGUP = 3;
	public static final int MSG_HFP_LOCAL = 4;
	public static final int MSG_HFP_REMOTE = 5;
	public static final int MSG_DEAL_DELAY = 6;
	public static final int MSG_COMMING = 7;
	public static final int MSG_TALKING = 8; // 接通
	static {
		// Map the buttons to the display characters 将按钮映射到显示字符
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

		// Map the buttons to the display characters
		mDisplayDTMFMap.put('1', ToneGenerator.TONE_DTMF_1);
		mDisplayDTMFMap.put('2', ToneGenerator.TONE_DTMF_2);
		mDisplayDTMFMap.put('3', ToneGenerator.TONE_DTMF_3);
		mDisplayDTMFMap.put('4', ToneGenerator.TONE_DTMF_4);
		mDisplayDTMFMap.put('5', ToneGenerator.TONE_DTMF_5);
		mDisplayDTMFMap.put('6', ToneGenerator.TONE_DTMF_6);
		mDisplayDTMFMap.put('7', ToneGenerator.TONE_DTMF_7);
		mDisplayDTMFMap.put('8', ToneGenerator.TONE_DTMF_8);
		mDisplayDTMFMap.put('9', ToneGenerator.TONE_DTMF_9);
		mDisplayDTMFMap.put('0', ToneGenerator.TONE_DTMF_0);
		mDisplayDTMFMap.put('#', ToneGenerator.TONE_DTMF_P);
		mDisplayDTMFMap.put('*', ToneGenerator.TONE_DTMF_S);

		mKeyCodeMap.put(R.id.one, KeyEvent.KEYCODE_1);
		mKeyCodeMap.put(R.id.two, KeyEvent.KEYCODE_2);
		mKeyCodeMap.put(R.id.three, KeyEvent.KEYCODE_3);
		mKeyCodeMap.put(R.id.four, KeyEvent.KEYCODE_4);
		mKeyCodeMap.put(R.id.five, KeyEvent.KEYCODE_5);
		mKeyCodeMap.put(R.id.six, KeyEvent.KEYCODE_6);
		mKeyCodeMap.put(R.id.seven, KeyEvent.KEYCODE_7);
		mKeyCodeMap.put(R.id.eight, KeyEvent.KEYCODE_8);
		mKeyCodeMap.put(R.id.nine, KeyEvent.KEYCODE_9);
		mKeyCodeMap.put(R.id.zero, KeyEvent.KEYCODE_0);
		mKeyCodeMap.put(R.id.pound, KeyEvent.KEYCODE_POUND);
		mKeyCodeMap.put(R.id.star, KeyEvent.KEYCODE_STAR);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		Log.e(TAG, "+++ ON CREATE +++");
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();

		number = bundle.getString("number"); // 通话号码
		time = bundle.getInt("time"); // 通话时间
		bCAllIn = bundle.getBoolean("type"); // 类型
		bStatus = CallStatus.CALL_TALKING;
		// bStatus = CallStatus.valueOf(bundle.getString("status")); // 通话状态
		mIsInPhone = bundle.getBoolean("main"); // ？？

		/**********
		 * mVoideIndevice = bundle.getBoolean("voide");// ？？
		 * mVoideIndevice暂定为true
		 * **********/
		mVoideIndevice = true;

		/*
		 * if (bStatus != null) { // 如果通话状态不为空 if
		 * (bStatus.equals(CallStatus.CALL_TALKING)) { // 如果状态为 在通话中
		 * soundInRemote = true; isConnect = true; isTaking = true; } else if
		 * (bStatus.equals(CallStatus.CALL_REVERSE))// 如果状态为 倒车 { soundInRemote
		 * = false; } isFinish = false;// ？？ mMainActivityFinish =
		 * !bundle.getBoolean("finishMainActivity", true); // ？？ }
		 */
		if (TextUtils.isEmpty(number)) {
			// finishThisActivity(true);
		}
		/*
		 * if (!bCAllIn) { Context c = null; try { c =
		 * getApplicationContext().createPackageContext("com.wedesign.phone",
		 * Context.CONTEXT_IGNORE_SECURITY);
		 * 
		 * } catch (NameNotFoundException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } SharedPreferences sh =
		 * c.getSharedPreferences("com.wedesign.phone",
		 * Context.MODE_WORLD_READABLE | Context.MODE_MULTI_PROCESS); Editor
		 * editor = sh.edit(); editor.putString("lastnumber", number);
		 * editor.commit(); }
		 */
		phonebluth = PhoneBluth.getInstance(getApplicationContext());
		initView();

		if (!bCAllIn) { // 如果电话类型为去电
			Log.d(TAG, "number.length()= " + number.length());
			callType = 7;
		} else { // 否则为来电
			callType = 6;
		}
		nowSoundStatus = 0;
		CallLogdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
		BtPhoneDB.createTable(CallLogdb, BtPhoneDB.Sql_create_calllog_tab); // 创建表
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG,"++onResume()++");
		Settings.System.putInt(getContentResolver(), "status_bar_disabled", 1); //这是啥？
		touchHangUp = false;
		isFinish = false;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG,"++onPause()++");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG,"++onStop()++");
	}
	
	protected void onDestroy(){
		super.onDestroy();
		Log.e(TAG,"++onDestroy()++");
	}

	private void initView() {
		Log.d(TAG, " initView()");
		tvNumber = (TextView) findViewById(R.id.callNumber); // 号码
		tvType = (TextView) findViewById(R.id.callType); // 类型
		tvName = (TextView) findViewById(R.id.callName); // 姓名
		chronomter = (Chronometer) findViewById(R.id.chronometer); // 计时器

		chronomter.setVisibility(View.INVISIBLE); // 计时器设为不可见

		btnCallin = (ImageButton) findViewById(R.id.callin); // 接听来电
		btnHandup = (ImageButton) findViewById(R.id.handup); // 挂断
		btnBtDevice = (ImageButton) findViewById(R.id.callBtDevice); // 车机声音
		btnBtPhone = (ImageButton) findViewById(R.id.callBtPhone); // 手机声音
		btnCallDial = (ImageButton) findViewById(R.id.callDial); // 电话取消

		btnPhoneInfo = (LinearLayout) findViewById(R.id.phoneInfo);
		btnDialpad = (LinearLayout) findViewById(R.id.dialpad_img);

		btnHandup.setOnClickListener(this);
		btnCallin.setOnClickListener(this);
		btnBtDevice.setOnClickListener(this);
		btnBtPhone.setOnClickListener(this);
		btnCallDial.setOnClickListener(this);
		mDbDataBase = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
		mDtmDigits = (EditText) findViewById(R.id.digits); // ？
		hand = handler;
		// Log.e(TAG, " name="+name+" peoplename="+peoplename);
		// peoplename = name;

		if (TextUtils.isEmpty(peoplename)) {
			try {
				peoplename = BtPhoneDB.queryPhoneName(mDbDataBase, BtPhoneDB.PhoneBookTable, number);
			} catch (Exception e) {
				peoplename = number;
			}
		}
		if (bCAllIn) { // 如果是来电
			btnCallin.setVisibility(View.VISIBLE);
			btnHandup.setVisibility(View.VISIBLE);
			btnCallDial.setVisibility(View.GONE);

		} else { // 否则为去电
			btnCallin.setVisibility(View.GONE);
			btnHandup.setVisibility(View.VISIBLE);
			Log.d(TAG, "btnCallDial.setVisibility(View.VISIBLE);");
			btnCallDial.setVisibility(View.VISIBLE);
		}
		chronomter.setVisibility(View.VISIBLE);
		chronomter.setBase(SystemClock.elapsedRealtime() - (time + 1) * 1000);
		chronomter.start();
		if (isTaking) {

			btnCallin.setVisibility(View.GONE);
			btnHandup.setVisibility(View.VISIBLE);

		}

		btnBtDevice.setVisibility(mVoideIndevice ? View.VISIBLE : View.GONE);
		btnBtPhone.setVisibility(mVoideIndevice ? View.GONE : View.VISIBLE);

		tvNumber.setText(number);
		tvName.setText(peoplename);

		// user
		// service.sorceCtrl("requestSourceToMusic");

		if ((!bCAllIn) || (isTaking)) {
			// service.sorceCtrl("phoneBegin");
			// service.phoneTransferBack();
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.handup:
			touchHangUp = true;
			phonebluth.reqHfpTerminateCurrentCall(); // 结束当前通话
			if (bCAllIn) { // 如果为来电
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
			soundInRemote = true;
		}
			break;
		case R.id.callBtDevice: {
			Log.d(TAG, "callBtDevice clicked");
			phonebluth.reqHfpAudioTransferToPhone(); // 切换声道到手机
			soundInRemote = false;

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
			phonebluth.reqHfpSendDtmf(mDisplayMap.get(v.getId()).toString());
			if (mMTPData == null)
				mMTPData = "" + mDisplayMap.get(v.getId());
			else
				mMTPData = mMTPData + mDisplayMap.get(v.getId());
			mDtmDigits.setText(mMTPData);
			mDtmDigits.setSelection(mDtmDigits.getText().length());

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
				/*
				 * case MSG_COMMING: number = (String) msg.obj;
				 * 
				 * try { peoplename = BtPhoneDB.queryPhoneName(mDbDataBase,
				 * BtPhoneDatabase.PhoneBookTable, number); } catch (Exception
				 * e) { peoplename = number; }
				 * 
				 * tvName.setText(peoplename); tvNumber.setText(number); break;
				 */

				/*
				 * case MSG_TALKING: { Log.d(TAG, "MSG_TALKING");
				 * chronomter.setBase(SystemClock.elapsedRealtime()); //
				 * 从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）
				 * chronomter.setVisibility(View.VISIBLE);// Chronometr是一个简单的定时器
				 * chronomter.start(); btnCallin.setVisibility(View.GONE);
				 * btnHandup.setVisibility(View.VISIBLE); Log.d(TAG,
				 * "phoneBegin in MSG_TALKING"); } break;
				 */
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
					// hangUp = true;
					// havaChangeSound = false;
					nowSoundStatus = 0;
					isConnect = false;
					Log.v(TAG, "case MSG_HANGUP");
					addCallLog();
					finishThisActivity(true);
				}

					break;
				case MSG_HFP_LOCAL: { // 车机音频到手机听筒
					Log.d(TAG, "MSG_HFP_LOCAL  蓝牙车机到手机听筒");
					handler.sendEmptyMessageDelayed(MSG_DEAL_DELAY, 100);
					if ((bCAllIn) && (!havaChangeSound)) {
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

					nowSoundStatus = 2;
				}
					break;
				case MSG_HFP_REMOTE: {
					btnBtDevice.setVisibility(View.VISIBLE);
					btnBtPhone.setVisibility(View.GONE);
					if ((bCAllIn) && (!havaChangeSound)) {
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
		if (CallLogdb != null) {
			Date nowTime = new Date(System.currentTimeMillis());
			SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");// System.currentTimeMillis()
																					// 得到的是1970年以来的毫秒数
			String retStrFormatNowDate = sdFormatter.format(nowTime);
			Log.v(TAG, "peoplename=" + peoplename + "  number=" + number + " callType=" + callType + "date=" + retStrFormatNowDate);
			BtPhoneDB.insert_calllog(CallLogdb, BtPhoneDB.CallLogTable, peoplename, number, callType, retStrFormatNowDate);
		}
	}

	private void finishThisActivity(boolean wantFinish) { // 结束activity的方法
		Log.d(TAG, "finishThisActivity " + isFinish + "  1");
		if (!isFinish) {
			isFinish = true;
			if (wantFinish) {
				finish();
				//System.exit(0); //408不能在蓝牙电话处于后台时电话结束后将CallActivity杀死，因此改为System.exit(0);
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
