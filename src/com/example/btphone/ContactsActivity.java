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

	private ImageButton btnDownload; // ������ϵ��
	private ImageButton btnNewContact; // �½���ϵ��
	private Button back; // ����
	private CheckBox cbCheckbox; // ����ѡ���Ƿ������ϵ��
	private ListView listview;
	private EditText etSearch;
	private ContactsActivity mCursorInterface;
	private ArrayList<ContactInfo> queryList = new ArrayList<ContactInfo>(); // listview��ʾ��list,��������Ĳ�ѯ�ı����仯
	private ArrayList<ContactInfo> mAllContactsList = new ArrayList<ContactInfo>();// ���е���ϵ�ˣ�һ�㲻��仯
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// ������ϵ�˵ĵ绰��Uri
	String[] projection = { ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.DATA1, "sort_key",
			ContactsContract.CommonDataKinds.Phone.CONTACT_ID, ContactsContract.CommonDataKinds.Phone.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY };
	public static final int HANDLER_EVENT_DIAL = 5;// ��ͨѶ¼���沦��绰
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST = 10;// ����һ����ϵ����Ϣ
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_START = 11; // ���ؿ�ʼ
	public static final int HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE = 12; // �������
	private ContactsListAdapter mAdapter;
	private Context mContext;
	private ContactQueryHandler asyncQueryHandler;
	private PhoneBluth phonebluth = null;
	public static JSONArray contactJsona = null; // ?
	private boolean update = false; // �Ƿ������ϵ�˵ı�־λ
	private boolean canQuery = true;// �ܷ���в�ѯ�ı�־λ
	private SQLiteDatabase phonebookdb;
	private PinyinComparator pinyinComparator; // ����ƴ��������ListView�����������
	private CharacterParser characterParser; // ����ת��Ϊƴ������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		Log.e(TAG, "++onCreate()++");
		mContext = this;
		hand = mHandler;
		pinyinComparator = new PinyinComparator(); // �½�ƴ���Ƚϵ���
		characterParser = CharacterParser.getInstance();// ʵ��������ת��Ϊƴ������
		phonebluth = PhoneBluth.getInstance(getApplicationContext());// ��ʼ��PhoneBluth
		phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr); // �������ݿ�
		BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab); // ������
		initView();
		initData();// ��ʼ�����ݣ����첽��ѯ��� asyncQueryHandler �����ݿ��н���ϵ����Ϣȡ����
	}

	@Override
	public synchronized void onResume() {
		Log.d(TAG, "onResume");
		if (DialActivity.ifneedreloadconnect) {
			btnDownload.performClick(); // ����ͽ�������
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

	// ��ʼ�����ݣ����첽��ѯ��� asyncQueryHandler �����ݿ��н���ϵ����Ϣȡ����
	private void initData() {
		Log.v(TAG, "initData()");
		queryList.clear();
		mAllContactsList.clear();
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
			case HANDLER_EVENT_DIAL:// ��ͨѶ¼���沦��绰
				String number = (String) msg.obj;
				if (phonebluth != null) {
					phonebluth.reqHfpDialCall(number);
				}
				break;

			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_START: // ������ϵ�˿�ʼ
				Log.v(TAG, "case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_START");
				queryList.clear();
				mAllContactsList.clear();
				canQuery = false;// ������ϵ��ʱ���ܽ��в�ѯ
				etSearch.setText("");
				BtPhoneDB.delete_table_data(phonebookdb, BtPhoneDB.PhoneBookTable); // ɾ��������
				break;

			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST: // ÿ����һ����ϵ����Ϣ
				NfPbapContact contact = (NfPbapContact) bundle.get("DATA_VCARD");
				String[] numbers = contact.getNumberArray();
				for (int i = 0; i < numbers.length; i++) { // ��NfPbap����ת��ΪContactInfo����,����ͬ������ͬ�ĺ�����Ϊ��ͬ����ϵ�ˣ��ֿ����
					// �����.getLastName()�еÿ��Ի�ȡȫ�����е�ֻ�ܻ�ȡ�գ���֪Ϊ��
					ContactInfo newcontact = new ContactInfo(contact.getLastName() + contact.getMiddleName() + contact.getFirstName(), numbers[i]);
					if (newcontact.getName().length() == 0) { // �������Ϊ�գ��˳�
						return;
					}
					if (phonebookdb != null) {
						BtPhoneDB.insert_phonebook(phonebookdb, "phonebook", newcontact.getName(), newcontact.getPhoneNum());
					}
					mAllContactsList.add(newcontact);
					Log.v(TAG, "name=" + newcontact.getName() );
				}
				break;
			case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE: // ������ϵ�˽���������Adapter
				Log.v(TAG, "case HANDLER_EVENT_UPDATE_BY_PASS_VCARD_TO_LIST_DONE");
				canQuery = true;// ���Խ��в�ѯ��
				Collections.sort(mAllContactsList, pinyinComparator);// �ڶ�����������һ��int�͵�ֵ�����൱��һ����־������sort������ʲô˳������list��������
				queryList.addAll(mAllContactsList);
				MyApplication ma = (MyApplication) getApplication();
				ma.setContactInfo(mAllContactsList);
				updataAdapter();
				break;
			}
		}
	};

	private void initView() {

		btnNewContact = (ImageButton) findViewById(R.id.add_contact);
		listview = (ListView) findViewById(R.id.listview);
		back = (Button) findViewById(R.id.back);
		cbCheckbox = (CheckBox) findViewById(R.id.isupdate);
		etSearch = (EditText) findViewById(R.id.search_src_text);
		listview.setOnItemClickListener(contactsClickListener); // ��listviewע�����������������¼�

		btnDownload = (ImageButton) findViewById(R.id.download_contact);
		btnDownload.setOnClickListener(new OnClickListener() { // ������ϵ�˵İ�ť
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
							phonebluth.reqPbapDownload(NfDef.PBAP_STORAGE_PHONE_MEMORY); // ��ʼ����
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
		back.setOnClickListener(new OnClickListener() { // ����
			@Override
			public void onClick(View v) {
				Log.v(TAG, "button_back onClicked");
				Intent myIntent = new Intent();
				myIntent = new Intent(ContactsActivity.this, DialActivity.class);
				startActivity(myIntent);
			}
		});
		cbCheckbox.setOnClickListener(new OnClickListener() { // �Ƿ������ϵ��

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

		etSearch.addTextChangedListener(new TextWatcher() { // �����ı�

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) { // ÿ���ı������
				// TODO Auto-generated method stub
				if (canQuery) {
					String content = etSearch.getText().toString();
					if (content.length() > 0) { // ����ı���Ϊ��
						ArrayList<ContactInfo> fileterList = (ArrayList<ContactInfo>) search(content);
						Log.v(TAG, "content=" + content + "  mAllContactsList.size()=" + mAllContactsList.size() + " fileterList.size()= " + fileterList.size());
						queryList = fileterList;
					} else { // ����ı�Ϊ��
						queryList = mAllContactsList;
					}
					updataAdapter();
					listview.setSelection(0); // ���б��ƶ���ָ����position
				}
			}
		});
	}

	// ģ����ѯ�ķ���
	private List<ContactInfo> search(String str) {
		List<ContactInfo> filterList = new ArrayList<ContactInfo>();// ���˺��list
		if (str.matches("^([0-9]|[/+])*$")) {// ������ʽ ƥ�����
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
					// ����ȫƥ��,��������ĸ��ƴƥ��,����ȫ��ĸƥ��
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

	private OnItemClickListener contactsClickListener = new OnItemClickListener() { // ���ͨѶ¼�ļ�����
		public void onItemClick(AdapterView<?> av, View v, int position, long id) {
			if (update) { // ������ϵ��
				ContactInfo info = queryList.get(position);
				Intent intent = new Intent(ContactsActivity.this, ContactsEditActivity.class);
				intent.putExtra("number", info.getPhoneNum());
				intent.putExtra("name", info.getName());
				intent.putExtra("update", update);
				startActivityForResult(intent, 10);
			} else { // �½���ϵ��
				if (queryList.size() == 0) {
					Toast.makeText(mContext, "contactListΪ��", Toast.LENGTH_LONG).show();
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

	private void updateJSON() {
		contactJsona = new JSONArray();
		for (ContactInfo info : queryList) {
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

	private void updataAdapter() {
		Log.v(TAG, "updataAdapter()");
		if (mAdapter == null) {
			mAdapter = new ContactsListAdapter(mContext, mHandler);
		}
		List<ContactInfo> ContactInfo = queryList;
		// updateJSON();?
		mAdapter.setData(ContactInfo);
		listview.setAdapter(mAdapter);
	}

	private class ContactQueryHandler extends AsyncQueryHandler { // �첽��ѯ���
		// token,һ�����ƣ���Ҫ������ʶ��ѯ,��֤Ψһ����.��Ҫ��onXXXComplete���������һ�¡�����Ȼ��Ҳ���Բ�һ�£�ͬ�������ݿ�Ĳ������������ö�Ӧ��onXXXComplete����?��
		// cookie,���봫��onXXXComplete����ʹ�õ�һ������(û�еĻ�����null����)
		class QueryArgs {
			public Uri uri;// �����в�ѯ��ͨ����Դ��־����:
			public String[] projection;// ��ѯ����
			public String selection;// ��������
			public String[] selectionArgs;// ��ѯ����
			public String orderBy;// ��������
		}

		public ContactQueryHandler(ContentResolver cr, ContactsActivity cursorInterface) {// ���췽��
			super(cr);
			mCursorInterface = cursorInterface;
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			mAllContactsList = BtPhoneDB.queryAllPhoneName(phonebookdb, BtPhoneDB.PhoneBookTable);
			filledData(mAllContactsList);
			// ����a-z��������Դ����
			Collections.sort(mAllContactsList, pinyinComparator);
			queryList = mAllContactsList;
			MyApplication ma = (MyApplication) getApplication();// ?
			ma.setContactInfo(queryList);
			updataAdapter();

		}
	}

	/**
	 * ΪListView�������
	 * 
	 * @param date
	 * @return
	 */
	private void filledData(ArrayList<ContactInfo> data) {

		for (int i = 0; i < data.size(); i++) {
			ContactInfo info = data.get(i);
			String pinyin = characterParser.getSelling(info.getName());
			String sortString = pinyin.substring(0, 1).toUpperCase();

			// ������ʽ���ж�����ĸ�Ƿ���Ӣ����ĸ
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
