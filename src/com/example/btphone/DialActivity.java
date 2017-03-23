package com.example.btphone;

import java.util.ArrayList;
import java.util.List;

import com.example.btphone.R;
import com.nforetek.bt.aidl.NfHfpClientCall;
import com.example.btphone.util.ContactsUtils;
import com.example.btphone.util.PhoneBluth;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btphone.adpter.DialerListAdapter;
import com.example.btphone.bean.ContactInfo;
import com.example.btphone.db.BtPhoneDB;

//�����绰��������
public class DialActivity extends Activity {
	private static String TAG = "DialActivity";
	private Button button_num1;
	private Button button_num2;
	private Button button_num3;
	private Button button_num4;
	private Button button_num5;
	private Button button_num6;
	private Button button_num7;
	private Button button_num8;
	private Button button_num9;
	private Button button_num0;
	private Button button_asterisk;
	private Button button_pound;
	private Button dial;
	private Button delete;
	private Button new_contact;
	private Button button_contacts;
	private Button button_calllog;
	private Button settings;
	private TextView num_field;
	private String input_num = "";
	public static final int MSG_INCOMING = 4;
	public static final int MSG_OUTGOING = 5;

	private String number; // �Զ����string ����������ĺ���
	public static final int MSG_HFP_CONNECTED = 1;
	private static final int HANDLER_EVENT_UPDATE_INFO_INPUT = 13;
	public static final int MSG_START_QUERY = 30;
	public static final int MSG_CONTACT_DELAY = 31;
	public static boolean bHfpState = false; // Hfp��״̬
	public static boolean bBlueToothStatus = false; // ����״̬
	public static boolean ifneedreloadconnect = false; // �Ƿ���Ҫ������ϵ��
	public static boolean ifneedreloadrecentrecorder = false; // �Ƿ���Ҫ��������ļ�¼
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// ������ϵ�˵ĵ绰��Uri
	String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.DATA1, "sort_key",
			ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY };
	private List<NfHfpClientCall> mCallList;
	private PhoneBluth phonebluth = null;
	private ArrayList<ContactInfo> showContactsList = new ArrayList<ContactInfo>(); // ��ListView��ʾ����ϵ���б�
	private ArrayList<ContactInfo> phoneList = new ArrayList<ContactInfo>();
	private ArrayList<ContactInfo> btPhoneList = new ArrayList<ContactInfo>();
	private ArrayList<ContactInfo> mAllContactsList = new ArrayList<ContactInfo>();
	private DialActivity mCursorInterface;
	private SQLiteDatabase phonebookdb;
	private ContactQueryHandler asyncQueryHandler;
	private DialerListAdapter mAdapter;
	private Context mContext;
	private ListView lvDialerTiplist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dial);
		Log.e(TAG, "++ onCreate() ++");
		mContext = this;// ����Context
		initView();
		hand = handler;
		phonebluth = PhoneBluth.getInstance(getApplicationContext()); // ��ʼ��PhoneBluth
		asyncQueryHandler = new ContactQueryHandler(getContentResolver(), DialActivity.this);// ��ʼ���첽��ѯ���

	}

	@Override
	protected void onResume() {
		Log.e(TAG, "++ onResume()++");
		handler.sendEmptyMessageDelayed(MSG_START_QUERY, 500); // �����ݿ��в�ѯ
		super.onResume();
	}

	public static Handler hand = null;

	public static Handler getHandler() {
		return hand;
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			switch (msg.what) {
			case MSG_HFP_CONNECTED: { // hfp����
				bHfpState = true;
				button_contacts.setEnabled(false);
			}
				break;
			case MSG_CONTACT_DELAY: {
				button_contacts.setEnabled(true);
			}
				break;
			case HANDLER_EVENT_UPDATE_INFO_INPUT:
				num_field.setText(b.getString("INFO_INPUT"));
				break;
			case MSG_OUTGOING: // �绰���
				number = (String) msg.obj;
				Log.v(TAG, "case MSG_OUTGOING");
				Intent intent = new Intent(DialActivity.this, CallActivity.class);
				intent.putExtra("number", number);
				intent.putExtra("isIncoming", false);// �绰���� false Ϊȥ��
				startActivity(intent);
				break;
			case MSG_INCOMING: // ����
				Log.v(TAG, "case MSG_COMMING");
				number = (String) msg.obj;
				Intent intent2 = new Intent(DialActivity.this, CallActivity.class);
				intent2.putExtra("number", number);
				intent2.putExtra("isIncoming", true); // �绰���� true Ϊ����
				startActivity(intent2);
				break;
			case MSG_START_QUERY: // ��ʼ��ѯ
				phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);

				// if not exsit then create the table
				BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab);
				asyncQueryHandler.startQuery(0, null, uri, projection, null, null, "sort_key COLLATE LOCALIZED asc");
				break;
			}
		}
	};

	private void initView() {
		button_num0 = (Button) findViewById(R.id.button_0);
		button_num1 = (Button) findViewById(R.id.button_1);
		button_num2 = (Button) findViewById(R.id.button_2);
		button_num3 = (Button) findViewById(R.id.button_3);
		button_num4 = (Button) findViewById(R.id.button_4);
		button_num5 = (Button) findViewById(R.id.button_5);
		button_num6 = (Button) findViewById(R.id.button_6);
		button_num7 = (Button) findViewById(R.id.button_7);
		button_num8 = (Button) findViewById(R.id.button_8);
		button_num9 = (Button) findViewById(R.id.button_9);
		button_asterisk = (Button) findViewById(R.id.button_asterisk);
		button_pound = (Button) findViewById(R.id.button_pound);
		dial = (Button) findViewById(R.id.dial);
		delete = (Button) findViewById(R.id.delete);
		new_contact = (Button) findViewById(R.id.new_contact);
		button_contacts = (Button) findViewById(R.id.button_contacts);
		button_calllog = (Button) findViewById(R.id.button_calllog);
		settings = (Button) findViewById(R.id.settings);
		num_field = (TextView) findViewById(R.id.num_field);
		lvDialerTiplist = (ListView) findViewById(R.id.dialer_tips_list);
		lvDialerTiplist.setVisibility(View.GONE);
		button_num0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("0");
			}
		});
		button_num1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("1");
			}
		});
		button_num2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("2");
			}
		});
		button_num3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("3");
			}
		});
		button_num4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("4");
			}
		});
		button_num5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("5");
			}
		});
		button_num6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("6");
			}
		});
		button_num7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("7");
			}
		});
		button_num8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("8");
			}
		});
		button_num9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("9");
			}
		});
		button_asterisk.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("*");
			}
		});
		button_pound.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NumClick("#");
			}
		});
		dial.setOnClickListener(new OnClickListener() { // ����绰
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_dial onClicked");
				try {
					if (input_num.length() > 0) { // ������볤�ȱ��������
						phonebluth.reqHfpDialCall(input_num);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		delete.setOnClickListener(new OnClickListener() { // ��һλ����
			@Override
			public void onClick(View v) {
				Log.v(TAG, "delete onClicked");
				// if(hfp_state==NfDef.STATE_CONNECTED){
				if (input_num.length() < 15 && input_num.length() > 0) {
					input_num = input_num.substring(0, input_num.length() - 1);
				}
				updateInputNumber(); // ��������ĺ���
				// }
			}
		});
		new_contact.setOnClickListener(new OnClickListener() { // �½���ϵ��
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(DialActivity.this, ContactsEditActivity.class);
						intent.putExtra("number", num_field.getText().toString());
						startActivity(intent);
					}
				});

		button_contacts.setOnClickListener(new OnClickListener() { // ������ϵ�˽���

					@Override
					public void onClick(View v) {
						Log.v(TAG, "button_contacts onClicked");
						Intent intent = new Intent(DialActivity.this, ContactsActivity.class);
						startActivity(intent);
					}
				});
		button_calllog.setOnClickListener(new OnClickListener() { // ����ͨ����¼����
					@Override
					public void onClick(View v) {
						Log.v(TAG, "button_calllog onClicked");
						Intent intent = new Intent(DialActivity.this, CalllogActivity.class);
						startActivity(intent);
					}
				});
		settings.setOnClickListener(new OnClickListener() { // �������ý���(��ʱ�ر�)
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_setting onClicked");
			}
		});

		num_field.addTextChangedListener(new TextWatcher() { // �����ı���ı�ļ���

					@Override
					public void beforeTextChanged(CharSequence s, int start, int count, int after) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						// TODO Auto-generated method stub
					}

					@Override
					public void afterTextChanged(Editable s) {
						// TODO Auto-generated method stub

						String content = num_field.getText().toString();
						Log.d(TAG, "afterTextChanged(Editable s)  content=" + content);
						if (content.length() > 0) {
							ArrayList<ContactInfo> fileterList = (ArrayList<ContactInfo>) search(content);
							Log.v(TAG, "fileterList.size()=" + fileterList.size());
							showContactsList = fileterList;
							for (ContactInfo showcontacts : showContactsList) {
								Log.v(TAG, "showcontacts.getPhoneNum()=" + showcontacts.getPhoneNum());
							}
							if (showContactsList.size() > 0) {
								lvDialerTiplist.setVisibility(View.VISIBLE);
								// tvNewContact.setVisibility(View.GONE);
								// tvUpdateContact.setVisibility(View.GONE);
							} else {
								lvDialerTiplist.setVisibility(View.GONE);
								// tvNewContact.setVisibility(View.VISIBLE);
								// tvUpdateContact.setVisibility(View.VISIBLE);
							}
							updataAdapter();
						} else {
							lvDialerTiplist.setVisibility(View.GONE);
							// tvNewContact.setVisibility(View.GONE);
							// tvUpdateContact.setVisibility(View.GONE);

						}
						lvDialerTiplist.setSelection(0);
					}
				});

		lvDialerTiplist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				ContactInfo contactInfo = showContactsList.get(position);
				Intent intent = new Intent(mContext, ContactViewActivity.class);
				intent.putExtra("name", contactInfo.getName());
				intent.putExtra("number", contactInfo.getPhoneNum());
				startActivity(intent);
			}
		});
	}

	/**
	 * ģ����ѯ
	 * 
	 * @param str
	 * @return
	 */

	private List<ContactInfo> search(String str) {
		List<ContactInfo> filterList = new ArrayList<ContactInfo>();// ���˺��list
		if (str.matches("^([0-9]|[/+])*$")) {// ������ʽ ƥ�����
			for (ContactInfo contact : mAllContactsList) {
				if (contact.getPhoneNum() != null) {
					if (contact.getPhoneNum().contains(str)) {
						if (!filterList.contains(contact)) {
							filterList.add(contact);
						}
					}
				}
			}
		}
		return filterList;
	}

	private void NumClick(String input) {
		Log.d(TAG, "NumClick()   input=" + input);
		if (input_num.length() < 15) {
			input_num += input;
			updateInputNumber();
		}

		if (mCallList != null && mCallList.size() > 0) {
			try {
				Log.v(TAG, "mCommand.reqHfpSendDtmf(input);");
				phonebluth.reqHfpSendDtmf(input); // DTMF����˫Ƶ�ź�
													// ����HFP����Զ���豸����DTMF
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void updateInputNumber() {
		sendHandlerMessage(HANDLER_EVENT_UPDATE_INFO_INPUT, new String[] { "INFO_INPUT" }, new String[] { input_num });

	}

	private void sendHandlerMessage(int what, String[] keys, String[] values) {
		Log.v(TAG, "keys.length=" + keys.length + "values.length=" + values.length);
		Message msg = Message.obtain(handler, what);// ? ����Ҳ����дΪMessage msg =
													// handler.obtainMessage();
		if (keys != null && values != null) {
			Bundle b = new Bundle();
			for (int i = 0; i < keys.length; i++) {
				b.putString(keys[i], values[i]);
			}
			msg.setData(b);
		}
		handler.sendMessage(msg);
	}

	private class ContactQueryHandler extends AsyncQueryHandler { // �첽��ѯ���

		class QueryArgs {
			public Uri uri;
			public String[] projection;
			public String selection;
			public String[] selectionArgs;
			public String orderBy;
		}

		public ContactQueryHandler(ContentResolver cr, DialActivity cursorInterface) {
			super(cr);
			mCursorInterface = cursorInterface;
		}

		public Cursor doQuery(Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy, boolean async) {
			if (async) {
				// Get 100 results first, which is enough to allow the user to
				// start scrolling,
				// while still being very fast.
				Uri limituri = uri.buildUpon().appendQueryParameter("limit", "100").build();
				QueryArgs args = new QueryArgs();
				args.uri = uri;
				args.projection = projection;
				args.selection = selection;
				args.selectionArgs = selectionArgs;
				args.orderBy = orderBy;

				startQuery(0, args, limituri, projection, selection, selectionArgs, orderBy);
				return null;
			}
			return ContactsUtils.query(mCursorInterface, uri, projection, selection, selectionArgs, orderBy);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			// Log.i("@@@", "query complete: " + cursor.getCount() + " " +
			// mActivity);
			// mCursorInterface.initCursor(cursor, cookie != null);
			Log.d(TAG, "onQueryComplete() !!!!!!!!!!!!!!!!!!!!!:");
			if (cursor != null && cursor.getCount() > 0) {//getCount()�����α��е�����rows
				try {
					cursor.moveToFirst();
					for (int i = 0; i < cursor.getCount(); i++) {
						cursor.moveToPosition(i);
						String name = cursor.getString(1);
						String number = cursor.getString(2);
						long contactId = cursor.getLong(4);
						ContactInfo contactInfo = new ContactInfo();
						contactInfo.setId(contactId);
						contactInfo.setPhoneNum(number);
						contactInfo.setName(name);
						if (contactInfo.getName() == null) {
							contactInfo.setName(contactInfo.getPhoneNum());
						}
						phoneList.add(contactInfo); //asyncQueryhandler ��ѯ�õ��Ľ��
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			showContactsList.addAll(phoneList);
			mAllContactsList.addAll(phoneList);
			btPhoneList = BtPhoneDB.queryAllPhoneName(phonebookdb, BtPhoneDB.PhoneBookTable);
			if (btPhoneList != null) {

				showContactsList.addAll(btPhoneList);
				mAllContactsList.addAll(btPhoneList);
			}

			String content = num_field.getText().toString();
			Log.v(TAG, "afterTextChanged(Editable s)  content=" + content);
			if (content.length() > 0) {
				ArrayList<ContactInfo> fileterList = (ArrayList<ContactInfo>) search(content);
				Log.v(TAG, "fileterList.size()=" + fileterList.size());
				showContactsList = fileterList;
				for (ContactInfo cilist : showContactsList) {
					Log.v(TAG, "cilist.getPhoneNum()=" + cilist.getPhoneNum());
				}
				if (showContactsList.size() > 0) {
					lvDialerTiplist.setVisibility(View.VISIBLE);
					// tvNewContact.setVisibility(View.GONE);
					// tvUpdateContact.setVisibility(View.GONE);
				} else {
					lvDialerTiplist.setVisibility(View.GONE);
					// tvNewContact.setVisibility(View.VISIBLE);
					// tvUpdateContact.setVisibility(View.VISIBLE);
				}
				// mAdapter.updateData(mContacts);
			} else {
				lvDialerTiplist.setVisibility(View.GONE);
				// tvNewContact.setVisibility(View.GONE);
				// tvUpdateContact.setVisibility(View.GONE);

				showContactsList = mAllContactsList;
			}

			lvDialerTiplist.setSelection(0);

			Log.d(TAG, "onQueryComplete():alist.size=" + showContactsList.size());
			// MyApplication ma = (MyApplication) getApplication();
			// ma.setContactInfo(ciList);
			updataAdapter();

			if (token == 0 && cookie != null && cursor != null && cursor.getCount() >= 100) {
				Log.d(TAG, "startQuery");
				QueryArgs args = (QueryArgs) cookie;
				startQuery(1, null, args.uri, args.projection, args.selection, args.selectionArgs, args.orderBy);
			}
		}
	}

	public void updataAdapter() { // ����Listview������
		Log.d(TAG, "updataAdapter");
		// TODO Auto-generated method stub
		String content = num_field.getText().toString();
		// inputCommand(content); ���������ݵĴ�������뿪����ģʽ����ʱ�ر�
		if (mAdapter == null) {
			mAdapter = new DialerListAdapter(mContext);
		}
		List<ContactInfo> ContactInfo = showContactsList;
		if (ContactInfo != null && ContactInfo.size() != 0) {
			mAdapter.setData(ContactInfo);
		}
		mAdapter.setSearchKey(content); // �趨��Ҫ����������
		lvDialerTiplist.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}

	// private void inputCommand(String str) {
	// int strleng = str.length();
	// int fistFlagIndex = str.indexOf(COMMAND_FLAG_START); //
	// �ɷ���ĳ��ָ�����ַ���ֵ���ַ������״γ��ֵ�λ��
	// int lastFlagIndex = str.lastIndexOf(COMMAND_FLAG_END);
	//
	// Context c1 = null;
	// try {
	// c1 = getApplicationContext().createPackageContext(
	// "com.wedesign.sourcemanager",
	// Context.CONTEXT_IGNORE_SECURITY);
	//
	// } catch (NameNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// // String project =SystemProperties.get("ro.pdi.project", "");
	// SharedPreferences sh1 = c1.getSharedPreferences(
	// "com.wedesign.sourcemanager", Context.MODE_WORLD_READABLE
	// | Context.MODE_MULTI_PROCESS);
	//
	// // final boolean showFactory = sh.getBoolean("factoryMode", false);
	//
	// String project = sh1.getString("projectName", "");
	// ;
	// boolean haveCommand = false;
	// Log.d("Btphone", "project = " + project);
	// if (project != null && project.equals("fulljoin-pdi")) {
	// TelephonyManager tm = (TelephonyManager) this
	// .getSystemService(Context.TELEPHONY_SERVICE);
	//
	// if (str.equals(COMMAND_FULLJOIN_FACTORYTEST)) {
	// haveCommand = true;
	// startApk("com.charjack.factorytest",
	// "com.charjack.factorytest.MainActivity");
	// } else if (str.equals(COMMAND_FULLJOIN_ICCIDCODE)) {
	// haveCommand = true;
	// String ICCID = tm.getSimSerialNumber();
	// warmingNoBluetoothConnect("ICCID:" + ICCID);
	// } else if (str.equals(COMMAND_FULLJOIN_IMEICODE)) {
	// haveCommand = true;
	// String IMEI = tm.getDeviceId();
	// warmingNoBluetoothConnect("IMEI:" + IMEI);
	// } else if (str.equals(COMMAND_FULLJOIN_CREATUPC)) {
	// haveCommand = true;
	// startApk("com.fulljoin.com.warehouse",
	// "com.fulljoin.com.warehouse.MainActivity");
	// }
	// }
	// if ((strleng >= 8) && (fistFlagIndex == 0)
	// && (lastFlagIndex == strleng - 4)) {
	// if (str.equals(COMMAND_FLAG_START + COMMAND_SAFE_SETTINGS
	// + COMMAND_FLAG_END)) {
	// haveCommand = true;
	// Log.d("Btphone", "sendBroadcast");
	// Intent intent = new Intent("Wedesign.action.SAFE_SETTINGS");
	// intent.putExtra("value", true);
	// sendBroadcast(intent);
	// CharSequence str1 = getString(R.string.open_safe_settings);
	// Toast.makeText(getApplicationContext(), str1,
	// Toast.LENGTH_SHORT).show();
	// // ���뿪����ģʽ
	// } else if (str.equals(COMMAND_FLAG_START + COMMAND_DEVELOPMENT_MODE
	// + COMMAND_FLAG_END)) {
	// haveCommand = true;
	// Log.d("Btphone", "sendBroadcast");
	// Intent intent = new Intent(
	// "Wedesign.action.DEVELOPMENT_PREF_SHOW");
	// intent.putExtra("value", true);
	// sendBroadcast(intent);
	// CharSequence str1 = getString(R.string.into_development_mode);
	// Toast.makeText(getApplicationContext(), str1,
	// Toast.LENGTH_SHORT).show();
	// // ���빤��ģʽ
	// } else if (str.equals(COMMAND_FLAG_START + COMMAND_FACTORY_MODE
	// + COMMAND_FLAG_END)) {
	// haveCommand = true;
	// Intent intent = new Intent("Wedesign.action.FACTORY_MODE_SHOW");
	// intent.putExtra("value", true);
	// sendBroadcast(intent);
	//
	// Log.d("Btphone", "Factory");
	//
	// } else if (str.equals(COMMAND_FLAG_START + COMMAND_SECURITY
	// + COMMAND_FLAG_END)) {
	// haveCommand = true;
	// Log.d("Btphone", "Security");
	// Context c = null;
	// try {
	// c = mContext.createPackageContext("com.wedesign.phone",
	// Context.CONTEXT_IGNORE_SECURITY);
	//
	// } catch (NameNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// SharedPreferences sh = c.getSharedPreferences(
	// "com.wedesign.phone", Context.MODE_WORLD_READABLE
	// | Context.MODE_MULTI_PROCESS);
	// Editor editor = sh.edit();
	// editor.putBoolean("security", true);
	// editor.commit();
	//
	// }
	//
	// }
	// if (haveCommand) {
	// haveCommand = false;
	// mDtmDigits.getText().clear();
	// mDelete.setPressed(false);
	// updataAdapter();
	// }
	// }

}
