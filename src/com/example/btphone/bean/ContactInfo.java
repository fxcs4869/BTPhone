package com.example.btphone.bean;

import android.util.Log;

public class ContactInfo implements Comparable<ContactInfo> {
	private Long id;
	private String name;
	private String phoneNum;
	private boolean bCheck;
	private boolean bIsletter;

	public ContactInfo() { // ���췽��

	}

	public ContactInfo(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	private String sortLetters; // ��ʾ����ƴ��������ĸ

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public boolean isbCheck() {
		return bCheck;
	}

	public void setbCheck(boolean bCheck) {
		this.bCheck = bCheck;
	}

	public String getSortLetters() {
		return sortLetters;
	}

	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}

	public boolean isbIsletter() {
		return bIsletter;
	}

	public void setbIsletter(boolean bIsletter) {
		this.bIsletter = bIsletter;
	}

	@Override
	public String toString() {

		return "name = " + name + "phoneNum = " + phoneNum + "sortLetters = " + sortLetters;
		// return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfo other = (ContactInfo) obj;

		if (this.id != other.id || this.bCheck != other.bCheck || this.bIsletter != other.bIsletter) {
			return false;
		}

		if (this.sortLetters == null) {
			if (other.sortLetters != null) {
				return false;
			}
		} else if (!this.sortLetters.equals(other.sortLetters)) {
			return false;
		}

		if (this.phoneNum == null) {
			if (other.phoneNum != null) {
				return false;
			}
		} else if (!this.phoneNum.equals(other.phoneNum)) {
			return false;
		}

		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(ContactInfo o2) {
		String TAG = "ContactInfo";

		String thisSortLetters = this.getSortLetters();
		String o2SortLetters = o2.getSortLetters();

		if (thisSortLetters.equals("#")) {
			Log.d(TAG, "o1 #");// ��o1��������ĸ���ֿ�ͷ��
			if (o2SortLetters.equals("#")) {
				Log.d(TAG, "o2 no #");
				return 0;
			} else {
				Log.d(TAG, "o2 #");
				return -1;
			}
		} else if (o2SortLetters.equals("#")) { // ��o1������ĸ���ֿ�ͷ,o2����
			Log.d(TAG, "o2 #");
			return 1;
		} else if (thisSortLetters.equals(o2SortLetters)) { // �����߶�����ĸ���ֿ�ͷ,��������ĸ���,
		// return this.isbIsletter()?1:0; //��o1������ĸ��ͷ�ź���,���ֿ�ͷ��ǰ��
			Log.d(TAG, "o1 o2 SortLetters is equals");
			if (this.isbIsletter()) {
				Log.d(TAG, "o1 is Letters");
				if (o2.isbIsletter()) {
					Log.d(TAG, "o2  Letter");
					return 0;
				} else {
					Log.d(TAG, "o2 not letter");
					return 1;
				}
			} else {
				if (this.isbIsletter()) {
					Log.d(TAG, "o2 is Letter");
					return -1;
				} else {
					Log.d(TAG, "o2 is not letter");
					return 0;
				}
			}

		} else { // ����������ĸ�����ʱ�Ƚ�����ĸ

			int i = thisSortLetters.compareTo(o2SortLetters);
			if (i == 0)
				return i;
			else
				return i > 0 ? 1 : -1;
		}
	}

}
