package com.example.btphone.util;

import com.example.btphone.CallActivity;
import com.example.btphone.CalllogActivity;
import com.example.btphone.ContactsActivity;
import com.example.btphone.DialActivity;
import com.nforetek.bt.aidl.NfHfpClientCall;
import com.nforetek.bt.aidl.NfPbapContact;
import com.nforetek.bt.aidl.UiCallbackHfp;
import com.nforetek.bt.aidl.UiCallbackPbap;
import com.nforetek.bt.aidl.UiCommand;
import com.nforetek.bt.res.NfDef;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

public class PhoneBluth {
	private static final String TAG = "PhoneBluth";
	public static final int MSG_CURRENT_DEVICE_ADDR = 1124;
	//public static String mCurrentConnectAddr = "38:BC:1A:BE:EE:16"; // 暂时先定死
	public static String mCurrentConnectAddr =null;
	public static Handler hand;
	private Context mContext;
	private volatile static PhoneBluth instance = null; // volatile
														// 变量可以被看作是一种“程度较轻的
														// synchronized”
	private int mProperty = NfDef.PBAP_PROPERTY_MASK_FN | // family name
															// "|"表示"或"
			NfDef.PBAP_PROPERTY_MASK_N | // name
			NfDef.PBAP_PROPERTY_MASK_TEL | NfDef.PBAP_PROPERTY_MASK_VERSION | NfDef.PBAP_PROPERTY_MASK_ADR | // address
			NfDef.PBAP_PROPERTY_MASK_EMAIL | NfDef.PBAP_PROPERTY_MASK_PHOTO;
	private static UiCommand mCommand = null;
	private String hfp_connected_address;
	private int hfp_state;
	private String call_num;
	private boolean isDownloadRange = false;
	private int mDownloadRangeCount = 0;

	public static Handler getHandler() {
		return hand;
	}

	private PhoneBluth(Context context) {
		Log.d(TAG, "SourceManager create");
		this.mContext = context;
		this.onCreate();
	}

	public static PhoneBluth getInstance(Context context) { // 单例模式
		if (instance == null) {
			synchronized (PhoneBluth.class) {
				if (instance == null) {
					instance = new PhoneBluth(context);
				}
			}
			instance.mContext = context;
		}

		return instance;
	}

	private void onCreate() {    //这个名字可以自取 
		Log.d(TAG, "onCreate()");
		hand = mHandler;
		mContext.bindService(new Intent("com.nforetek.bt.START_UI_SERVICE"), mConnection, Context.BIND_AUTO_CREATE);
	}

	public void reqHfpDialCall(String number) { // 拨打电话
		Log.d(TAG, "reqHfpDialCall  number="+number);
		if (mCommand == null) {
			return;
		}
		try {
			mCommand.reqHfpDialCall(number);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpTerminateCurrentCall() { // 结束当前通话
		Log.d(TAG, "reqHfpTerminateCurrentCall");
		if (mCommand == null) {
			return;
		}
		try {
			mCommand.reqHfpTerminateCurrentCall();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpAnswerCall(int flag) { // 接听来电

		if (mCommand == null) {
			return;
		}
		try {
			Log.d(TAG, "mCommand.reqHfpAnswerCall(flag);");
			mCommand.reqHfpAnswerCall(flag);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpRejectIncomingCall() { // 拒接来电
		Log.d(TAG, "phoneDail");
		if (mCommand == null) {
			return;
		}
		try {
			mCommand.reqHfpRejectIncomingCall();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpAudioTransferToCarkit() { // 切换声道到车机
		if (mCommand == null) {
			return;
		}
		try {
			Log.d(TAG, "reqHfpAudioTransferToCarkit");
			mCommand.reqHfpAudioTransferToCarkit();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpAudioTransferToPhone() { // 切换声道到手机
		if (mCommand == null) {
			return;
		}
		try {
			Log.d(TAG, "reqHfpAudioTransferToPhone");
			mCommand.reqHfpAudioTransferToPhone();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqHfpSendDtmf(String number) {
		Log.d(TAG, "phoneDail");
		if (mCommand == null) {
			return;
		}
		try {
			mCommand.reqHfpSendDtmf(number);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void reqPbapDownload(int value) {
		Log.d(TAG, "reqPbapDownload");
		if (mCommand == null) {
			Log.d(TAG, "mCommand==null");
			return;
		}
		try {
			mCommand.reqPbapDownload(hfp_connected_address, value, mProperty);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {

			case MSG_CURRENT_DEVICE_ADDR:  
				mCurrentConnectAddr = (String) msg.obj;
				Log.d(TAG, "ADDR=" + mCurrentConnectAddr);
				break;
			/*
			 * case MSG_BLUETOOTH_SERVICE_CONNECTED: { if (mCommand == null) {
			 * bindService(); } else { try { mCommand.getHfpConnectedAddress();
			 * // service.getCurrentDeviceName();
			 * mCommand.getHfpConnectionState(); } catch (RemoteException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); } } }
			 * break;
			 */
			default:
				break;
			}

		}
	};

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d(TAG, "onServiceConnected");
			mCommand = UiCommand.Stub.asInterface(service);
			if (mCommand == null) {
				Log.e(TAG, "mCommand is null!!");
			} 
			try {
				Log.e(TAG, "mCommand.registerHfpCallback(mCallbackHfp)");
				mCommand.registerHfpCallback(mCallbackHfp); // 注册HfpCallback
				mCommand.registerPbapCallback(mCallbackPbap);// 注册PbapCallback
				hfp_connected_address = mCommand.getTargetAddress(); // 获取hfp_connected_address
				if (hfp_connected_address.equals(NfDef.DEFAULT_ADDRESS)) {
				}
				hfp_state = mCommand.getHfpConnectionState(); // 获取HfpConnectionState
				mCommand.setPbapDownloadNotify(1); // 下载频率设置
				if (call_num != null) {
					mCommand.reqPbapDatabaseQueryNameByNumber(hfp_connected_address, call_num); // 这是想干啥？
				}

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mCommand = null;
			Log.d(TAG, "onServiceDisconnected");

		}

	};

	private UiCallbackHfp mCallbackHfp = new UiCallbackHfp.Stub() {

		@Override
		public void onHfpServiceReady() throws RemoteException {
			// TODO Auto-generated method stub
			Log.d(TAG, "onHfpServiceReady()");

		}

		@Override
		// 110代表hfp未连接，120代表连接中，140代表连接上
		public void onHfpStateChanged(String address, int prevState, int newState) throws RemoteException {
			// TODO Auto-generated method stub
			Log.d(TAG, "onHfpStateChanged()  prevState=" + prevState + "  newState=" + newState);
			Handler handler = null;
			if (newState == 140) {
				DialActivity.bHfpState = true;
				handler = DialActivity.getHandler();
				if (handler != null)
					handler.sendEmptyMessage(DialActivity.MSG_HFP_CONNECTED);
				handler.sendEmptyMessageDelayed(DialActivity.MSG_CONTACT_DELAY, 500); // 这里设置了延时2s，才能点击打开联系人的功能
			} else if (newState == 110) { // 这里设置了hfp没有连接时需要发送的消息，暂时不用

				DialActivity.bBlueToothStatus = false;
				DialActivity.ifneedreloadconnect = true;
				DialActivity.ifneedreloadrecentrecorder = true;
				// handler=
				// * MainActivity.getHandler(); if(handler != null)
				// * handler.sendEmptyMessage(MainActivity.MSG_HF_DISCONNECTED);
				// *
				// * handler = CallActivity.getHandler(); if(handler != null)
				// * handler.sendEmptyMessage(CallActivity.MSG_DISCONNECT);
				// *
				// * handler = RecentCallActivity.getHandler(); if(handler !=
				// * null)
				// handler.sendEmptyMessage(CallActivity.MSG_DISCONNECT);
				// *
				// * handler = ContactActivity.getHandler(); if(handler!= null)
				// * handler.sendEmptyMessage(CallActivity.MSG_DISCONNECT);
				// */
			}

		}

		// 挂断电话、 蓝牙->手机听筒 140->110
		// 拨打电话 、手机听筒->蓝牙 120 ->140
		@Override
		public void onHfpAudioStateChanged(String address, int prevState, int newState) throws RemoteException {
			// TODO Auto-generated method stub

			Log.d(TAG, "onHfpAudioStateChanged()  prevState=" + prevState + "  newState=" + newState);
			Handler handler1 = DialActivity.getHandler();
			Handler handler2 = CallActivity.getHandler();
			if (prevState == 140 & newState == 110 & handler2 != null) {// 蓝牙->手机听筒
				handler2.sendMessage(handler2.obtainMessage(CallActivity.MSG_HFP_LOCAL));
				Log.d(TAG, "handler2.sendMessage(handler2.obtainMessage(CallActivity.MSG_HFP_LOCAL));");
			} else if (prevState == 120 & newState == 140 & handler2 != null) {// 手机听筒->蓝牙
				handler2.sendMessage(handler2.obtainMessage(CallActivity.MSG_HFP_REMOTE));
				Log.d(TAG, "handler2.sendMessage(handler2.obtainMessage(CallActivity.MSG_HFP_REMOTE));");
			}

		}

		@Override
		public void onHfpVoiceDial(String address, boolean isVoiceDialOn) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void onHfpErrorResponse(String address, int code) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void onHfpRemoteTelecomService(String address, boolean isTelecomServiceOn) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void onHfpRemoteRoamingStatus(String address, boolean isRoamingOn) throws RemoteException {
			// TODO Auto-generated method stub //漫游状态

		}

		@Override
		public void onHfpRemoteBatteryIndicator(String address, int currentValue, int maxValue, int minValue) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void onHfpRemoteSignalStrength(String address, int currentStrength, int maxStrength, int minStrength) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void onHfpCallChanged(String address, NfHfpClientCall call) throws RemoteException {
			// TODO Auto-generated method stub
			// call.getState() 去电3 接通0 挂断7 来电4
			Handler handler1 = DialActivity.getHandler();
			Handler handler2 = CallActivity.getHandler();
			Log.d(TAG, "onHfpCallChanged()    call.getState()=" + call.getState());
			switch (call.getState()) {
			case 3: // 去电
				if (handler1 != null) {
					handler1.sendMessage(handler1.obtainMessage(DialActivity.MSG_OUTGOING, call.getNumber()));
				}
				break;
			case 7: // 挂断
				if (handler2 != null) {
					Log.d(TAG, "handler2.sendEmptyMessage(CallActivity.MSG_HANGUP);");
					handler2.sendEmptyMessage(CallActivity.MSG_HANGUP);
				}
				break;
			case 4: // 来电
				if (handler1 != null) {
					Log.d(TAG, "call.getNumber()=" + call.getNumber());
					handler1.sendMessage(handler1.obtainMessage(DialActivity.MSG_INCOMING, call.getNumber()));
					Log.d(TAG, "(DialActivity.MSG_COMMING, call.getNumber()));");

				}

				break;
			case 0: // 接通
				if (handler2 != null) {
					Log.d(TAG, "handler2.sendEmptyMessage(CallActivity.MSG_TALKING);");
					handler2.sendEmptyMessage(CallActivity.MSG_TALKING);
				}
				break;
			}

		}

		@Override
		public void retPbapDatabaseQueryNameByNumber(String address, String target, String name, boolean isSuccess) throws RemoteException {
			// TODO Auto-generated method stub

		}

	};

	private UiCallbackPbap mCallbackPbap = new UiCallbackPbap.Stub() {

		@Override
		// 每下载一条联系人
		public void retPbapDownloadedContact(NfPbapContact contact) throws RemoteException {
			// 这里初始下载的联系人(NfPbapContact
			// contact)为一个名字带若干号码的，contact.getNumberArray()：获取号码的数组
			Log.i(TAG, "retPbapDownloadedContact() ");
			if (isDownloadRange) {
				mDownloadRangeCount++;
				Log.v(TAG, "Piggy Check download count: " + mDownloadRangeCount);
			}
			sendHandlerMessageWithContact(ContactsActivity.HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST, "DATA_VCARD", contact);

		}

		@Override
		// 每下载一条通话记录，调用一次,只用其中的名字，类型，时间，号码， 来电：6 去电：7 未接：5
		public void retPbapDownloadedCallLog(String address, String firstName, String middleName, String lastName, String number, int type, String timestamp) throws RemoteException {
			// TODO Auto-generated method stub
			String name = firstName + middleName + lastName;
			if (name == "") { // 如果名字为" ",就设为“未知”
				name = "未知";
			}
			Log.i(TAG, "retPbapDownloadedCallLog() " + "name=" + name + " (" + number + ") " + timestamp + "  type=" + type);
			sendHandlerMessageWithCalllog(CalllogActivity.HANDLER_EVENT_ADD_VCARD_TO_BY_PASS_LIST, "TIME", timestamp, "NAME", name, "NUMBER", number, "TYPE", type);
		}

		@Override
		public void retPbapDeleteDatabaseByAddressCompleted(String address, boolean isSuccess) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void retPbapDatabaseQueryNameByPartialNumber(String address, String target, String[] names, String[] numbers, boolean isSuccess) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void retPbapDatabaseQueryNameByNumber(String address, String target, String name, boolean isSuccess) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void retPbapDatabaseAvailable(String address) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		public void retPbapCleanDatabaseCompleted(boolean isSuccess) throws RemoteException {
			// TODO Auto-generated method stub

		}

		@Override
		// 下载状态(包括下载联系人和通话记录)改变时调用 即开始下载或者下载结束时，开始下载为160，结束为110.
		public void onPbapStateChanged(String address, int prevState, int newState, int reason, int counts) throws RemoteException {
			Log.v(TAG, "onPbapStateChanged() " + address + " state: " + prevState + "->" + newState + "reason=" + reason + "counts=" + counts);
			Handler handler = ContactsActivity.getHandler();
			Handler handler2 = CalllogActivity.getHandler();
			if (newState == 110) { // 下载(联系人或通话记录)结束。必须sendMessage是因为修改view要在子线程中进行
				Log.v(TAG, "handler.sendEmptyMessage");
				if (handler2 == null) {
					Log.v(TAG, "handler2==null");
				} else {
					Log.v(TAG, "handler2!=null");
				}
				// handler.sendEmptyMessage(ContactsActivity.HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE);
				handler2.sendEmptyMessage(CalllogActivity.HANDLER_DOWNLOAD_CALLLOG_DONE);
			}

			/*
			 * String state = ""; switch (reason) {
			 * 
			 * case NfDef.REASON_DOWNLOAD_FULL_CONTENT_COMPLETED :
			 * 
			 * break; case NfDef.REASON_DOWNLOAD_FAILED : state = "Fail";
			 * //hideTitle(); //type = 9; break; case
			 * NfDef.REASON_DOWNLOAD_TIMEOUT : //enableButton(true); //state =
			 * "Timeout"; //type = 9; //hideTitle(); break; default: if
			 * (newState == NfDef.STATE_READY) { state = "Ready"; } else if
			 * (newState == NfDef.STATE_DOWNLOADED) { state = "Update"; } else
			 * if (newState == NfDef.STATE_CONNECTED) { state = "Downloading"; }
			 * break;
			 * 
			 * }
			 */

		}

		@Override
		public void onPbapServiceReady() throws RemoteException {
			Log.v(TAG, "onPbapServiceReady");

		}

		@Override
		public void onPbapDownloadNotify(String address, int storage, int totalContacts, int downloadedContacts) throws RemoteException {
			// TODO Auto-generated method stub

		}
	};

	private void sendHandlerMessageWithContact(int what, String key, NfPbapContact value) {
		Handler handler = ContactsActivity.getHandler();
		if (handler == null) {
			Log.e(TAG, "handler == null !");
			return;
		}
		Message msg = Message.obtain(handler, what);
		if (key != null && value != null) {
			Bundle b = new Bundle();
			b.putParcelable(key, value);
			msg.setData(b);
		}
		handler.sendMessage(msg);
	}

	private void sendHandlerMessageWithCalllog(int what, String key1, String time, String key2, String name, String key3, String number, String key4, int type) {
		Handler handler = CalllogActivity.getHandler();
		if (handler == null) {
			Log.e(TAG, "handler == null !");
			return;
		}
		Message msg = Message.obtain(handler, what);
		if (key1 != null && key2 != null && key3 != null && key4 != null && time != null && name != null && number != null) {
			Bundle b = new Bundle();
			b.putString(key1, time);
			b.putString(key2, name);
			b.putString(key3, number);
			b.putInt(key4, type);
			msg.setData(b);
		}
		handler.sendMessage(msg);
	}

}
