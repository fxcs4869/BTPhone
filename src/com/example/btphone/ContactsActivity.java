package com.example.btphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;

import com.example.btphone.adpter.ContactsListAdapter;
import com.example.btphone.bean.ContactInfo;
import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.CharacterParser;
import com.example.btphone.util.MyApplication;
import com.example.btphone.util.PhoneBluth;
import com.example.btphone.util.PinyinComparator;
import com.nforetek.bt.aidl.NfPbapContact;
import com.nforetek.bt.res.NfDef;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContactsActivity extends Activity {
	private static String TAG = "ContactsActivity";

	private ImageButton btnDownload; // 下载联系人
	private Button back; // 返回
	private CheckBox cbCheckbox; // 用于选择是否更新联系人
	private ListView listview;
	private EditText etSearch;
	private ArrayList<ContactInfo> queryList = new ArrayList<ContactInfo>(); // listview显示的list,会因输入的查询文本而变化
	private ArrayList<ContactInfo> mAllContactsList = new ArrayList<ContactInfo>();// 所有的联系人，一般不会变化
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// 管理联系人的电话的Uri
	String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.DATA1, "sort_key",
			ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY };
	public static final int HANDLER_EVENT_DIAL = 5;// 在通讯录界面拨打电话
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST = 10;// 下载一条联系人信息
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE = 12; // 下载完成
	private ContactsListAdapter mAdapter;
	private Context mContext;
	private ContactQueryHandler asyncQueryHandler;
	private PhoneBluth phonebluth = null;
	public static JSONArray contactJsona = null; // ?
	private boolean update = false; // 是否更新联系人的标志位
	private boolean canQuery = true;// 能否进行查询的标志位
	private SQLiteDatabase phonebookdb;
	private PinyinComparator pinyinComparator; // 根据拼音来排列ListView里面的数据类
	private CharacterParser characterParser; // 汉字转换为拼音的类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		Log.e(TAG, "++onCreate()++");
		mContext = this;
		hand = mHandler;
		pinyinComparator = new PinyinComparator(); // 新建拼音比较的类
		characterParser = CharacterParser.getInstance();// 实例化汉字转换为拼音的类
		phonebluth = PhoneBluth.getInstance(getApplicationContext());// 初始化PhoneBluth
		phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr); // 创建数据库
		BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab); // 创建表
		initView();
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
		Log.e(TAG, "-onPause() -");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.e(TAG, "--onStop()--");
	}

	@Override
	public void onDestroy() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		mHandler = null;
		Log.v(TAG, "--onDestroy()--");
		super.onDestroy();
	}

	// 初始化数据，用异步查询框架 asyncQueryHandler 从数据库中将联系人信息取出来
	private void initData() {
		Log.d(TAG, "initData()");
		queryList.clear();
		mAllContactsList.clear();
		asyncQueryHandler = new ContactQueryHandler(getContentResolver());
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
					mAllContactsList.add(newcontact);
					Log.v(TAG, "name=" + newcontact.getName() + "mAllContactsList.size()=" + mAllContactsList.size() + "queryList.size()=" + queryList.size());
				}
				break;
			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE: // 下载联系人结束，更新Adapter
				Log.v(TAG, "case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE");
				canQuery = true;// 可以进行查询了
				Collections.sort(mAllContactsList, pinyinComparator);// 第二个参数返回一个int型的值，就相当于一个标志，告诉sort方法按什么顺序来对list进行排序。
				// queryList.addAll(mAllContactsList);
				Log.v(TAG, "queryList.size()=" + queryList.size());
				updataAdapter();
				break;
			}
		}
	};

	private void initView() {

		listview = (ListView) findViewById(R.id.listview);
		back = (Button) findViewById(R.id.back);
		cbCheckbox = (CheckBox) findViewById(R.id.isupdate);
		etSearch = (EditText) findViewById(R.id.search_src_text);
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
						MyApplication.load_ContactsOrCalllog = true;
						queryList.clear();
						mAllContactsList.clear();
						canQuery = false;// 下载联系人时不能进行查询
						etSearch.setText("");
						BtPhoneDB.delete_table_data(phonebookdb, BtPhoneDB.PhoneBookTable); // 删除表数据
						try {
							phonebluth.reqPbapDownload(NfDef.PBAP_STORAGE_PHONE_MEMORY); // 开始下载
						} catch (Exception e) {
							e.printStackTrace();
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

		etSearch.addTextChangedListener(new TextWatcher() { // 搜索文本

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) { // 每当文本变更后
				// TODO Auto-generated method stub
				if (canQuery) {
					String content = etSearch.getText().toString();
					if (content.length() > 0) { // 如果文本不为空
						ArrayList<ContactInfo> fileterList = (ArrayList<ContactInfo>) search(content);
						Log.v(TAG, "content=" + content + "  mAllContactsList.size()=" + mAllContactsList.size() + " fileterList.size()= " + fileterList.size());
						queryList = fileterList;
					} else { // 如果文本为空
						queryList = mAllContactsList;
						Log.v(TAG, "!!!!!!!!!!!!!!!!!!!!!");
					}
					updataAdapter();
					listview.setSelection(0); // 将列表移动到指定的position
				}
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
				ContactInfo info = queryList.get(position);
				Intent intent = new Intent(ContactsActivity.this, ContactsEditActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				intent.putExtra("update", update);
				startActivityForResult(intent, 10);
			} else { // 新建联系人
				if (queryList.size() == 0) {
					Toast.makeText(mContext, "contactList为空", Toast.LENGTH_LONG).show();
					return;
				}
				ContactInfo info = queryList.get(position);

				Intent intent = new Intent(ContactsActivity.this, ContactViewActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				startActivity(intent);
			}
		}
	};

	private void updataAdapter() {
		Log.v(TAG, "updataAdapter()");
		if (mAdapter == null) {
			mAdapter = new ContactsListAdapter(mContext, mHandler);
		}
		List<ContactInfo> ContactInfo = queryList;
		Log.v(TAG, "queryList.size()=" + queryList.size());
		mAdapter.setData(ContactInfo);
		listview.setAdapter(mAdapter);
	}

	private class ContactQueryHandler extends AsyncQueryHandler { // 异步查询框架
		// token,一个令牌，主要用来标识查询,保证唯一即可.需要跟onXXXComplete方法传入的一致。（当然你也可以不一致，同样在数据库的操作结束后会调用对应的onXXXComplete方法?）
		// cookie,你想传给onXXXComplete方法使用的一个对象。(没有的话传递null即可)

		public ContactQueryHandler(ContentResolver cr) {// 构造方法
			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {

			mAllContactsList = BtPhoneDB.queryAllPhoneName(phonebookdb, BtPhoneDB.PhoneBookTable);
			Log.d(TAG, "onQueryComplete!!!!  mAllContactsList.size()=" + mAllContactsList.size());
			// filledData(mAllContactsList);
			// 根据a-z进行排序源数据
			Collections.sort(mAllContactsList, pinyinComparator);
			queryList = mAllContactsList;
			updataAdapter();
		}
	}

}
