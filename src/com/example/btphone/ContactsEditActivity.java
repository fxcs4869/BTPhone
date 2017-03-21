package com.example.btphone;

import com.example.btphone.db.BtPhoneDB;
import com.example.btphone.util.PhoneBluth;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactsEditActivity extends Activity {

	private EditText tvname;
	private EditText tvnumber;
	private Button comfirm;
	private Button concle;
	private String name; //传递过来的名字
	private String number;//传递过来的号码
	private String newname; //新名字
	private String newnumber;//新号码
	private boolean update;
	private SQLiteDatabase phonebookdb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_edit);

		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		name = bundle.getString("name");
		number = bundle.getString("number");
		update = bundle.getBoolean("update");
		initView();
		phonebookdb = BtPhoneDB.getPhoneBookDb(PhoneBluth.mCurrentConnectAddr);
		// if not exsit then create the table
		BtPhoneDB.createTable(phonebookdb, BtPhoneDB.Sql_create_phonebook_tab);

	}

	private void initView() {
		tvname = (EditText) findViewById(R.id.name);
		tvnumber = (EditText) findViewById(R.id.number);
		comfirm = (Button) findViewById(R.id.comfirm);
		concle = (Button) findViewById(R.id.concle);
		tvname.setText(name);
		tvnumber.setText(number);
		comfirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(update){
					newname = tvname.getText().toString();
					newnumber = tvnumber.getText().toString();
					updateContact();//更新联系人
				}else {
				name = tvname.getText().toString();
				number = tvnumber.getText().toString();
				addContact();}   //添加联系人
			}
		});
		
		concle.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				finish();
				
			}
			
		});
		

	}

	protected void addContact() { // 更新联系人
		if (TextUtils.isEmpty(name)) {
			Toast.makeText(ContactsEditActivity.this, "名字不能为空！", Toast.LENGTH_LONG).show();
			return;
		}
		if (TextUtils.isEmpty(number)) {
			Toast.makeText(ContactsEditActivity.this, "号码不能为空！", Toast.LENGTH_LONG).show();
			return;
		}
		if (phonebookdb != null) {
			BtPhoneDB.insert_phonebook(phonebookdb, "phonebook", name, number);
			Toast.makeText(ContactsEditActivity.this, "创建联系人成功", Toast.LENGTH_SHORT).show();
			setResult(1);// 如果在startActivityForResult起来的Activity里面设置setResult,结果并不会马上返回给parent的Activity,只有当前Activity被finish,结果才会被发送给parent的onActivityResult去处理
			this.finish();
		}
	}
	protected void updateContact(){
		if (TextUtils.isEmpty(name)) {
			Toast.makeText(ContactsEditActivity.this, "名字不能为空！", Toast.LENGTH_LONG).show();
			return;
		}
		if (TextUtils.isEmpty(number)) {
			Toast.makeText(ContactsEditActivity.this, "号码不能为空！", Toast.LENGTH_LONG).show();
			return;
		}
		
		if (phonebookdb != null) {
			BtPhoneDB.update_phonebook(phonebookdb, "phonebook", name, number,newname,newnumber);
			Toast.makeText(ContactsEditActivity.this, "更新联系人成功", Toast.LENGTH_SHORT).show();
			setResult(2);// 如果在startActivityForResult起来的Activity里面设置setResult,结果并不会马上返回给parent的Activity,只有当前Activity被finish,结果才会被发送给parent的onActivityResult去处理
			this.finish();
		}
	}
}
