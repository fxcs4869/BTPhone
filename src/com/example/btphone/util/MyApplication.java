package com.example.btphone.util;

import java.util.List;

import com.example.btphone.bean.ContactInfo;

public class MyApplication extends android.app.Application{
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
