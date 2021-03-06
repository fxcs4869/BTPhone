package com.example.btphone;

import java.util.ArrayList;
import java.util.List;
import com.example.btphone.R;
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
import android.provider.Settings;
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
import com.example.btphone.adpter.DialerListAdapter;
import com.example.btphone.bean.ContactInfo;
import com.example.btphone.db.BtPhoneDB;

//蓝牙电话的主界面
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

	private String number; // 自定义的string 代表打入打出的号码
	public static final int MSG_HFP_CONNECTED = 1;
	private static final int HANDLER_EVENT_UPDATE_INFO_INPUT = 13;
	public static final int MSG_START_QUERY = 30;
	public static final int MSG_CONTACT_DELAY = 31;
	public static boolean bHfpState = false; // Hfp的状态
	public static boolean bBlueToothStatus = false; // 蓝牙状态
	public static boolean ifneedreloadconnect = false; // 是否需要下载联系人
	public static boolean ifneedreloadrecentrecorder = false; // 是否需要下载最近的记录
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// 管理联系人的电话的Uri
	String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.DATA1, "sort_key",
			ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY };
	private PhoneBluth phonebluth = null;
	private ArrayList<ContactInfo> showContactsList = new ArrayList<ContactInfo>(); // 在ListView显示的联系人列表
	private ArrayList<ContactInfo> btPhoneList = new ArrayList<ContactInfo>(); // 通过数据库查询得到的联系人
	private ArrayList<ContactInfo> mAllContactsList = new ArrayList<ContactInfo>();// 全体联系人
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
		initView();
		mContext = this;// 定义Context
		hand = handler;
		phonebluth = PhoneBluth.getInstance(getApplicationContext()); // 初始化PhoneBluth
		asyncQueryHandler = new ContactQueryHandler(getContentResolver());// 初始化异步查询框架

	}

	@Override
	protected void onResume() {
		Log.e(TAG, "++ onResume()++");
		handler.sendEmptyMessageDelayed(MSG_START_QUERY, 500); // 从数据库中查询
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.e(TAG, "++ onPause()++");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.e(TAG, "++ onStop()++");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.e(TAG, "++ onDestroy()++");
		super.onDestroy();
	}

	public static Handler hand = null;

	public static Handler getHandler() {
		return hand;
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			Bundle b = msg.getData();
			switch (msg.what) {
			case HANDLER_EVENT_UPDATE_INFO_INPUT:
				num_field.setText(b.getString("INFO_INPUT"));
				break;
			case MSG_OUTGOING: // 电话打出
				number = (String) msg.obj;
				Log.v(TAG, "case MSG_OUTGOING");
				Intent intent = new Intent(DialActivity.this, CallActivity.class);
				intent.putExtra("number", number);
				intent.putExtra("isIncoming", false);// 电话类型 false 为去电
				startActivity(intent);
				break;
			case MSG_INCOMING: // 打入
				Log.v(TAG, "case MSG_COMMING");
				number = (String) msg.obj;
				Intent intent2 = new Intent(DialActivity.this, CallActivity.class);
				intent2.putExtra("number", number);
				intent2.putExtra("isIncoming", true); // 电话类型 true 为来电
				startActivity(intent2);
				break;
			case MSG_START_QUERY: // 开始查询
				phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
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
		dial.setOnClickListener(new OnClickListener() { // 拨打电话
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_dial onClicked");
				try {
					if (input_num.length() > 0) { // 输入号码长度必须大于零
						phonebluth.reqHfpDialCall(input_num);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		delete.setOnClickListener(new OnClickListener() { // 减一位号码
			@Override
			public void onClick(View v) {
				Log.v(TAG, "delete onClicked");
				// if(hfp_state==NfDef.STATE_CONNECTED){
				if (input_num.length() < 16 && input_num.length() > 0) {
					input_num = input_num.substring(0, input_num.length() - 1);
				}
				updateInputNumber(); // 更新输入的号码
				// }
			}
		});
		new_contact.setOnClickListener(new OnClickListener() { // 新建联系人
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(DialActivity.this, ContactsEditActivity.class);
						intent.putExtra("number", num_field.getText().toString());
						startActivity(intent);
					}
				});

		button_contacts.setOnClickListener(new OnClickListener() { // 进入联系人界面

					@Override
					public void onClick(View v) {
						Log.v(TAG, "button_contacts onClicked");
						Intent intent = new Intent(DialActivity.this, ContactsActivity.class);
						startActivity(intent);
					}
				});
		button_calllog.setOnClickListener(new OnClickListener() { // 进入通话记录界面
					@Override
					public void onClick(View v) {
						Log.v(TAG, "button_calllog onClicked");
						Intent intent = new Intent(DialActivity.this, CalllogActivity.class);
						startActivity(intent);
					}
				});
		settings.setOnClickListener(new OnClickListener() { // 进入设置界面
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_setting onClicked");
				Intent intent_settings = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
				startActivity(intent_settings);
			}
		});

		num_field.addTextChangedListener(new TextWatcher() { // 号码文本框改变的监听

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
							if (showContactsList.size() > 0) {
								lvDialerTiplist.setVisibility(View.VISIBLE);
							} else {
								lvDialerTiplist.setVisibility(View.GONE);
							}
							updataAdapter();
						} else {
							lvDialerTiplist.setVisibility(View.GONE);
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
	 * 模糊查询
	 * 
	 * @param str
	 * @return
	 */

	private List<ContactInfo> search(String str) {
		List<ContactInfo> filterList = new ArrayList<ContactInfo>();// 过滤后的list
		if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
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

		try {
			Log.v(TAG, "mCommand.reqHfpSendDtmf(input);");
			phonebluth.reqHfpSendDtmf(input); // DTMF多音双频信号,请求HFP连接远程设备发送DTMF

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateInputNumber() {
		sendHandlerMessage(HANDLER_EVENT_UPDATE_INFO_INPUT, new String[] { "INFO_INPUT" }, new String[] { input_num });

	}

	private void sendHandlerMessage(int what, String[] keys, String[] values) {
		Log.v(TAG, "keys.length=" + keys.length + "values.length=" + values.length);
		Message msg = Message.obtain(handler, what);// 或者也可以写为Message msg
													// =handler.obtainMessage();
		if (keys != null && values != null) {
			Bundle b = new Bundle();
			for (int i = 0; i < keys.length; i++) {
				b.putString(keys[i], values[i]);
			}
			msg.setData(b);
		}
		handler.sendMessage(msg);
	}

	private class ContactQueryHandler extends AsyncQueryHandler { // 异步查询框架

		public ContactQueryHandler(ContentResolver cr) {
			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			Log.d(TAG, "onQueryComplete() ");
			btPhoneList = BtPhoneDB.queryAllPhoneName(phonebookdb, BtPhoneDB.PhoneBookTable);
			if (btPhoneList != null) {
				mAllContactsList.addAll(btPhoneList);
			}
		}
	}

	public void updataAdapter() { // 更新Listview的数据
		Log.d(TAG, "updataAdapter");
		// TODO Auto-generated method stub
		String content = num_field.getText().toString();
		// inputCommand(content); 对输入内容的处理，如进入开发者模式，暂时关闭
		if (mAdapter == null) {
			mAdapter = new DialerListAdapter(mContext);
		}
		List<ContactInfo> ContactInfo = showContactsList;
		if (ContactInfo != null && ContactInfo.size() != 0) {
			mAdapter.setData(ContactInfo);
		}
		mAdapter.setSearchKey(content); // 设定需要高亮的内容
		lvDialerTiplist.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}

}
