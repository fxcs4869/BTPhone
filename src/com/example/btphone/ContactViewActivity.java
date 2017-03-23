package com.example.btphone;

import com.example.btphone.util.PhoneBluth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ContactViewActivity extends Activity {
	private String number = null;
	private String name = null;
	private TextView tvName;
	private TextView tvNumber;
	private Button btnDial;
	private Button btnback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_view);
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		number = intent.getStringExtra("number");
		tvName = (TextView) findViewById(R.id.name);
		tvNumber = (TextView) findViewById(R.id.number);
		btnback = (Button) findViewById(R.id.back);
		btnDial=(Button)findViewById(R.id.dial);
		tvName.setText(name);
		tvNumber.setText(number);
		btnDial.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 PhoneBluth phonebluth=PhoneBluth.getInstance(ContactViewActivity.this);//≥ı ºªØPhoneBluth
				if (phonebluth != null) {
					phonebluth.reqHfpDialCall(number);
				}
			}
		});
		
		
		btnback.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}
