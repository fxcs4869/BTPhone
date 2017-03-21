package com.example.btphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.btphone.adpter.ContactsListAdapter;
import com.example.btphone.bean.ContactInfo;
import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.CharacterParser;
import com.example.btphone.util.ContactsUtils;
import com.example.btphone.util.MyApplication;
import com.example.btphone.util.PhoneBluth;
import com.example.btphone.util.PinyinComparator;
import com.nforetek.bt.aidl.NfPbapContact;
import com.nforetek.bt.res.NfDef;

import android.annotation.SuppressLint;
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
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContactsActivity extends Activity {
	private static String TAG = "ContactsActivity";

	private ImageButton btnDownload; // 下载联系人
	private ImageButton btnNewContact; // 新建联系人
	private Button back; // 返回
	private CheckBox cbCheckbox; // 用于选择是否更新联系人
	private ListView listview;
	private EditText etSearch;
	private ContactsActivity mCursorInterface;

	private ArrayList<ContactInfo> ciList = new ArrayList<ContactInfo>(); // listview显示的list,会因输入的查询文本而变化
	private ArrayList<ContactInfo> phoneList = new ArrayList<ContactInfo>();
	private ArrayList<ContactInfo> btPhoneList = new ArrayList<ContactInfo>();
	private ArrayList<ContactInfo> mAllContactsList = new ArrayList<ContactInfo>();// 所有的联系人，一般不会变化
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// 管理联系人的电话的Uri
	String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.DATA1, "sort_key",
			ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY };
	public static final int HANDLER_EVENT_DIAL = 5;// 在通讯录界面拨打电话
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST = 10;// 下载一条联系人信息
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE = 11; // 下载完成
	private ContactsListAdapter mAdapter;
	private Context mContext;
	private ContactQueryHandler asyncQueryHandler;
	private PhoneBluth phonebluth = null;
	public static JSONArray contactJsona = null; // ?
	private boolean update = false; // 是否更新联系人的标志位
	private SQLiteDatabase phonebookdb;
	private PinyinComparator pinyinComparator; // 根据拼音来排列ListView里面的数据类
	private CharacterParser characterParser; // 汉字转换为拼音的类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		Log.e(TAG, "+++ ON CREATE +++" + PhoneBluth.mCurrentConnectAddr);
		mContext = this;
		hand = mHandler;
		initView();
		pinyinComparator = new PinyinComparator(); // 新建拼音比较的类
		characterParser = CharacterParser.getInstance();// 实例化汉字转换为拼音的类
		phonebluth = PhoneBluth.getInstance(getApplicationContext());// 初始化PhoneBluth
		phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr); // 创建数据库
		BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab); // 创建表
		initData();// 初始化数据，用异步查询框架 asyncQueryHandler 从数据库中将联系人信息取出来
	}

	@Override
	public synchronized void onResume() {
		Log.d(TAG, "onResume");
		if (DialActivity.ifneedreloadconnect) {
			btnDownload.performClick(); // 进入就进行下载
			DialActivity.ifneedreloadconnect = false;
		}
		super.onResume();
		// updataAdapter();
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

	@Override
	public void onDestroy() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		mHandler = null;
		Log.v(TAG, "--- ON DESTROY ---");
		super.onDestroy();
	}

	// 初始化数据，用异步查询框架 asyncQueryHandler 从数据库中将联系人信息取出来
	private void initData() {
		Log.v(TAG, "initData()");
		asyncQueryHandler = new ContactQueryHandler(getContentResolver(), ContactsActivity.this);
		asyncQueryHandler.startQuery(0, null, uri, projection, null, null, "sort_key COLLATE LOCALIZED asc");
	}

	public static Handler hand = null;

	public static Handler getHandler() {
		return hand;
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			switch (msg.what) {
			case HANDLER_EVENT_DIAL:// 在通讯录界面拨打电话
				String number = (String) msg.obj;
				if (phonebluth != null) {
					phonebluth.reqHfpDialCall(number);
				}
				break;
			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST: // 每下载一条联系人信息
				NfPbapContact contact = (NfPbapContact) bundle.get("DATA_VCARD");
				String[] numbers = contact.getNumberArray();
				for (int i = 0; i < numbers.length; i++) { // 将NfPbap类型转换为ContactInfo类型,这里同名但不同的号码视为不同的联系人，分开存放
					// 这里的.getLastName()有得可以获取全名，有的只能获取姓，不知为何
					ContactInfo newcontact = new ContactInfo(contact.getLastName() + contact.getMiddleName() + contact.getFirstName(), numbers[i]);
					if (newcontact.getName().length() == 0) { // 如果名字为空，退出
						return;
					}
					if (phonebookdb != null) {
						BtPhoneDB.insert_phonebook(phonebookdb, "phonebook", newcontact.getName(), newcontact.getPhoneNum());
					}
					btPhoneList.add(newcontact);
					ciList.add(newcontact);
					mAllContactsList.add(newcontact);
					Log.v(TAG, "name=" + newcontact.getName() + "  btPhoneList.length=" + btPhoneList.size());
				}
				break;
			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE: // 下载联系人结束，更新Adapter
				Log.d(TAG, "HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE");
				Collections.sort(ciList, pinyinComparator); // 第二个参数返回一个int型的值，就相当于一个标志，告诉sort方法按什么顺序来对list进行排序。
				Collections.sort(mAllContactsList, pinyinComparator);

				MyApplication ma = (MyApplication) getApplication();
				ma.setContactInfo(mAllContactsList);
				updataAdapter();
			}
		}
	};

	private void initView() {

		btnNewContact = (ImageButton) findViewById(R.id.add_contact);
		listview = (ListView) findViewById(R.id.listview);
		back = (Button) findViewById(R.id.back);
		cbCheckbox = (CheckBox) findViewById(R.id.isupdate);
		listview.setOnItemClickListener(contactsClickListener); // 给listview注册监听器来触发点击事件

		btnDownload = (ImageButton) findViewById(R.id.download_contact);
		btnDownload.setOnClickListener(new OnClickListener() { // 下载联系人的按钮
					@Override
					public void onClick(View v) {
						Log.v(TAG, "download onClicked");
						/*
						 * if (MainActivity.bBlueToothStatus == false) {
						 * CharSequence str = getString(R.string.bt_unconn_tip);
						 * Toast.makeText(getApplicationContext(), str,
						 * Toast.LENGTH_SHORT) .show(); return; }
						 */
						try {
							Log.v(TAG, "List.clear()");
							btPhoneList.clear();
							ciList.clear();
							mAllContactsList.clear();

							BtPhoneDB.delete_table_data(phonebookdb, BtPhoneDB.PhoneBookTable); // 删除表数据
							BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab); // 创建表
							phonebluth.reqPbapDownload(NfDef.PBAP_STORAGE_PHONE_MEMORY); // 开始下载
						} catch (Exception e) {
							e.printStackTrace();
							// enableButton(true);
						}
					}

				});
		back.setOnClickListener(new OnClickListener() { // 返回
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_back onClicked");
				Intent myIntent = new Intent();
				myIntent = new Intent(ContactsActivity.this, DialActivity.class);
				startActivity(myIntent);
			}
		});
		cbCheckbox.setOnClickListener(new OnClickListener() { // 是否更新联系人

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (cbCheckbox.isChecked()) {
							update = true;
						} else {
							update = false;
						}
						Log.v(TAG, "cbCheckbox onClicked    update= " + update);
					}
				});

		etSearch = (EditText) findViewById(R.id.search_src_text);

		etSearch.addTextChangedListener(new TextWatcher() { // 搜索文本

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) { // 每当文本变更后
				// TODO Auto-generated method stub
				String content = etSearch.getText().toString();
				if (content.length() > 0) { // 如果文本不为空
					ArrayList<ContactInfo> fileterList = (ArrayList<ContactInfo>) search(content);
					Log.v(TAG, "content=" + content + "  mAllContactsList.size()=" + mAllContactsList.size() + " fileterList.size()= " + fileterList.size());
					ciList = fileterList;
					updataAdapter();
				} else { // 如果文本为空
					ciList = mAllContactsList;
					updataAdapter();
				}
				listview.setSelection(0); // 将列表移动到指定的position

			}
		});
	}

	// 模糊查询的方法
	private List<ContactInfo> search(String str) {
		List<ContactInfo> filterList = new ArrayList<ContactInfo>();// 过滤后的list
		if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
			for (ContactInfo contact : mAllContactsList) {
				if (contact.getPhoneNum() != null && contact.getName() != null) {
					if (contact.getPhoneNum().contains(str) || contact.getName().contains(str)) {
						if (!filterList.contains(contact)) {
							filterList.add(contact);
						}
					}
				}
			}
		} else if (str.matches("^([a-z]|[A-Z])*$")) {
			str = str.toLowerCase();
			for (ContactInfo contact : mAllContactsList) {
				String nameString = characterParser.getSelling(contact.getName()).toLowerCase();
				Log.d(TAG, str + " : " + nameString);
				if (nameString.contains(str)) {
					filterList.add(contact);
				}
			}

		} else {
			for (ContactInfo contact : mAllContactsList) {
				if (contact.getName() != null && contact.getName() != null) {
					// 姓名全匹配,姓名首字母简拼匹配,姓名全字母匹配
					if (contact.getName().toLowerCase(Locale.CHINESE).contains(str.toLowerCase(Locale.CHINESE))) {
						if (!filterList.contains(contact)) {
							filterList.add(contact);
						}
					}
				}
			}
		}
		return filterList;
	}

	private OnItemClickListener contactsClickListener = new OnItemClickListener() { // 点击通讯录的监听器
		public void onItemClick(AdapterView<?> av, View v, int position, long id) {
			if (update) { // 更新联系人
				ContactInfo info = ciList.get(position);
				Intent intent = new Intent(ContactsActivity.this, ContactsEditActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				intent.putExtra("update", update);
				startActivityForResult(intent, 10);
			} else { // 新建联系人
				if (ciList.size() == 0) {
					Toast.makeText(mContext, "contactList为空", Toast.LENGTH_LONG).show();
					return;
				}
				ContactInfo info = ciList.get(position);

				Intent intent = new Intent(ContactsActivity.this, ContactViewActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				startActivity(intent);
			}
		}
	};

	private void updateJSON() {
		contactJsona = new JSONArray();
		for (ContactInfo info : ciList) {
			JSONObject object = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject arrayObject = new JSONObject();
			try {
				arrayObject.put("number", info.getPhoneNum());
				arrayObject.put("flag", "");
				array.put(arrayObject);
				object.put("name", info.getName());
				object.put("phone_info", array);
				contactJsona.put(object);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void updataAdapter() {
		// TODO Auto-generated method stub
		Log.v(TAG, "updataAdapter()");
		if (mAdapter == null) {
			mAdapter = new ContactsListAdapter(mContext, mHandler);
			listview.setAdapter(mAdapter);
		}
		List<ContactInfo> ContactInfo = ciList;
		updateJSON();
		if (ContactInfo != null && ContactInfo.size() != 0) {
			Log.v(TAG, "listview.setAdapter(mAdapter);");
			mAdapter.setData(ContactInfo);
			listview.setAdapter(mAdapter);
		} else {
			// Toast.makeText(mContext, "联系人信息为空啊大哥", Toast.LENGTH_LONG).show();
		}
	}

	/*
	 * @Override protected void onActivityResult(int requestCode, int
	 * resultCode, Intent data) { // TODO Auto-generated method stub if
	 * (requestCode == 10) { if (resultCode == 1) { // etSearch.setText("");
	 * ciList.clear(); ciList = BtPhoneDB.queryAllPhoneName(phonebookdb,
	 * BtPhoneDB.PhoneBookTable); // mAllContactsList.clear(); //
	 * mAllContactsList.addAll(ciList);
	 * 
	 * MyApplication ma = (MyApplication) getApplication();
	 * ma.setContactInfo(ciList); updataAdapter(); } else if (resultCode == 2) {
	 * this.finish(); } } super.onActivityResult(requestCode, resultCode, data);
	 * }
	 */

	private class ContactQueryHandler extends AsyncQueryHandler { // 异步查询框架
		// token,一个令牌，主要用来标识查询,保证唯一即可.需要跟onXXXComplete方法传入的一致。（当然你也可以不一致，同样在数据库的操作结束后会调用对应的onXXXComplete方法?）
		// cookie,你想传给onXXXComplete方法使用的一个对象。(没有的话传递null即可)
		class QueryArgs {
			public Uri uri;// （进行查询的通用资源标志符）:
			public String[] projection;// 查询的列
			public String selection;// 限制条件
			public String[] selectionArgs;// 查询参数
			public String orderBy;// 排序条件
		}

		public ContactQueryHandler(ContentResolver cr, ContactsActivity cursorInterface) {// 构造方法
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
			// Log.i("@@@", "query complete: " + cursor.getCount() + "   " +
			// mActivity);
			// mCursorInterface.initCursor(cursor, cookie != null);

			if (cursor != null && cursor.getCount() > 0) {
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
						phoneList.add(contactInfo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			ciList.addAll(phoneList);

			mAllContactsList.addAll(phoneList);
			btPhoneList = BtPhoneDB.queryAllPhoneName(phonebookdb, BtPhoneDB.PhoneBookTable);
			ciList.addAll(btPhoneList);
			mAllContactsList.addAll(btPhoneList);

			filledData(ciList);
			filledData(mAllContactsList);

			// 根据a-z进行排序源数据
			Collections.sort(ciList, pinyinComparator);
			Collections.sort(mAllContactsList, pinyinComparator);

			MyApplication ma = (MyApplication) getApplication();
			ma.setContactInfo(ciList);
			updataAdapter();

			if (token == 0 && cookie != null && cursor != null && cursor.getCount() >= 100) {
				QueryArgs args = (QueryArgs) cookie;
				startQuery(1, null, args.uri, args.projection, args.selection, args.selectionArgs, args.orderBy);
			}
		}
	}

	/**
	 * 为ListView填充数据
	 * 
	 * @param date
	 * @return
	 */
	private void filledData(ArrayList<ContactInfo> data) {

		for (int i = 0; i < data.size(); i++) {
			ContactInfo info = data.get(i);
			String pinyin = characterParser.getSelling(info.getName());
			String sortString = pinyin.substring(0, 1).toUpperCase();

			// 正则表达式，判断首字母是否是英文字母
			// if(sortString.matches("[A-Z]")){
			// info.setSortLetters(sortString.toUpperCase());
			// }else{
			// info.setSortLetters("#");
			// }

			if (sortString.matches("[A-Z]")) {
				info.setSortLetters(sortString.toUpperCase());

				String firstString = info.getName().substring(0, 1);
				Pattern p = Pattern.compile("[a-zA-Z]");
				Matcher m = p.matcher(firstString);
				if (m.matches()) {
					info.setbIsletter(true);
				} else {
					info.setbIsletter(false);
				}
			} else {
				info.setSortLetters("#");
				info.setbIsletter(false);
			}

			data.set(i, info);
		}

	}

}
