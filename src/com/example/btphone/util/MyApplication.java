package com.example.btphone.util;

import java.util.List;

import com.example.btphone.bean.ContactInfo;

public class MyApplication extends android.app.Application{
	//设定全局变量
	public static boolean load_ContactsOrCalllog;//判断是下载联系人还是下载通话记录 true代表下载联系人
	private List<ContactInfo> ContactInfo;

	public List<ContactInfo> getContactInfo() {
		return ContactInfo;
	}

	public void setContactInfo(List<ContactInfo> contactInfo) {
		ContactInfo = contactInfo;
	}
	
	public void addContactInfo(List<ContactInfo> contactInfo) {
		if(contactInfo != null){
			ContactInfo.addAll(contactInfo);
		}
	}

	@Override
	public void onCreate() {

	}
}
