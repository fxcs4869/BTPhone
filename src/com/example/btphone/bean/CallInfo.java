package com.example.btphone.bean;

public class CallInfo {
	private Long id;        //id
	private String name;    //����   
	private String phoneNum;//�绰����
	private String date;    //ͨ����ϸʱ��
	private int CallType;    //�������ͣ����硢ȥ�硢δ�ӣ�
	private boolean bCheck;
	private int Calltime;  
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
	public int getCalltime() {
		return Calltime;
	}
	public void setCalltime(int Calltime) {
		this.Calltime = Calltime;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCallType() {
		return CallType;
	}
	public void setCallType(int callType) {
		CallType = callType;
	}
	public boolean isbCheck() {
		return bCheck;
	}
	public void setbCheck(boolean bCheck) {
		this.bCheck = bCheck;
	}
}
