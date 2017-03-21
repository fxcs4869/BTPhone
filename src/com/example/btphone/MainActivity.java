package com.example.btphone;

import com.nforetek.bt.aidl.UiCommand;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button BtPhonePage;
	private Button SettingPage;
	private UiCommand mCommand;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		startService(new Intent("com.nforetek.bt.START_UI_SERVICE"));
		// bindService(intent,conn,flags)  conn是一个代表与service连接状态的类
		bindService(new Intent("com.nforetek.bt.START_UI_SERVICE"), this.mConnection, BIND_AUTO_CREATE);
	}

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 调用IxxxxService.Stub.asInterface(IBinder obj) 即可得到一个IxxxxService 实例
			mCommand = UiCommand.Stub.asInterface(service);
			if (mCommand == null) {
				Toast.makeText(getApplicationContext(), "please choose a device :)", Toast.LENGTH_LONG).show();
				finish();
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
		}
	};

	public void initView() {
		BtPhonePage = (Button) findViewById(R.id.BtPhonePage);
		SettingPage = (Button) findViewById(R.id.SettingPage);
		BtPhonePage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DialActivity.class);
				startActivity(intent);
			}

		});

		SettingPage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SettingActivity.class);
				startActivity(intent);
			}

		});
	}

}
