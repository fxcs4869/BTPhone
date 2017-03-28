package com.example.btphone.db;

import java.util.ArrayList;
import com.example.btphone.bean.ContactInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BtPhoneDB {

	private static String mDbPath = "/data/data/com.example.btphone/BtPhone";
	public static String Sql_create_phonebook_tab = "create table if not exists phonebook(_id integer primary key autoincrement,phonename text,phonenumber text)";
	public static String Sql_create_calllog_tab = "create table if not exists calllog(_id integer primary key autoincrement,phonename text,phonenumber text,calltype integer,time text)";
	public static String PhoneBookTable = "phonebook";
	public static String CallLogTable = "calllog";
	private static String TAG = "BtPhoneDB";

	public static SQLiteDatabase getPhoneBookDb(String addr) { //
		String path = mDbPath + "_" + addr + ".db";

		Log.d(TAG, "path=" + path);
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(path, null);
		return db;
	}

	public static void createTable(SQLiteDatabase db, String Sql_table_name) { //
		// ִ��SQL���
		db.execSQL(Sql_table_name);
	}

	// insert phonebook data to table 添加联系人
	public static void insert_phonebook(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num) {
		// ʵ��������ֵ
		ContentValues cValue = new ContentValues();
		cValue.put("phonename", Phone_name);
		cValue.put("phonenumber", Phone_num);
		db.insert(Table_name, null, cValue);
	}

	// 更新联系人
	public static void update_phonebook(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num, String oldName, String oldNumber) {
		// ʵ��������ֵ
		ContentValues cValue = new ContentValues();
		cValue.put("phonename", Phone_name);
		cValue.put("phonenumber", Phone_num);
		db.insert(Table_name, null, cValue); // 为什么这里要先插入

		// 修改条件
		String whereClause = "phonename=? and phonenumber=?";
		// 修改添加参数
		String[] whereArgs = { oldName, oldNumber };

		db.update(Table_name, cValue, whereClause, whereArgs);
	}

	// 删除联系人
	public static void delete_phonebook(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num) {
		String[] args = { Phone_name, Phone_num };
		db.delete(Table_name, "phonename=? and phonenumber=?", args);
	}

	// insert call data to table 插入通话记录
	public static void insert_calllog(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num, int calltype, String time) {
		ContentValues cValue = new ContentValues();
		cValue.put("phonename", Phone_name);
		cValue.put("phonenumber", Phone_num);
		cValue.put("calltype", calltype);
		cValue.put("time", time);
		db.insert(Table_name, null, cValue);
	}

	// 删除指定的通话记录
	public static void delete_calllog(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num, int calltype, String time) {
		String[] args = { Phone_name, Phone_num, "" + calltype };
		db.delete(Table_name, "phonename=? and phonenumber=? and calltype=?", args);
	}

	// search name with num
	public static String queryPhoneName(SQLiteDatabase db, String Table_name, String Phone_num) {
		String Phonename;
		Cursor cursor = db.query("phonebook", new String[] { "phonename", "phonenumber" }, "phonenumber= ?", new String[] { Phone_num }, null, null, null); // "ORDEY BY ASC"
		while (cursor.moveToNext()) {
			Phonename = cursor.getString(cursor.getColumnIndex("phonename"));
			return Phonename;
		}

		return null;
	}
	
	// 查询所有电话联系人
	public static ArrayList<ContactInfo> queryAllPhoneName(SQLiteDatabase db, String Table_name) {
		ArrayList<ContactInfo> dataList = new ArrayList<ContactInfo>();
		if (db == null) {
			return null;
		}
		Cursor cursor = db.query("phonebook", new String[] { "phonename", "phonenumber" }, "", new String[] {}, null, null, null); // "ORDEY BY ASC"


		while (cursor.moveToNext()) {
			ContactInfo info = new ContactInfo();
			info.setName(cursor.getString(cursor.getColumnIndex("phonename")));
			info.setPhoneNum(cursor.getString(cursor.getColumnIndex("phonenumber")));
			dataList.add(info);
		}
		return dataList;
	}

	// 根据通话类型查询通话记录，暂时没有用到
	public static void queryCallLog(SQLiteDatabase db, String CallType) {
		String Phonename;
		String Phonenum;
		String time;
		Cursor cursor = db.query("calllog", new String[] { "phonename", "phonenumber", "time" }, "calltype=?", new String[] { CallType }, null, null, null); // "ORDEY BY ASC"

		while (cursor.moveToNext()) {
			Phonenum = cursor.getString(cursor.getColumnIndex("phonenumber"));
			Phonename = cursor.getString(cursor.getColumnIndex("phonename"));
			time = cursor.getString(cursor.getColumnIndex("time"));
			Log.d(TAG, "Cursor data ==============" + Phonenum + Phonename + "  " + time);
		}
	}

	// 删除表数据
	public static void delete_table_data(SQLiteDatabase db, String Table_name) {
		// ɾ��SQL���
		String sql = "delete from " + Table_name;
		// ִ��SQL���
		db.execSQL(sql);
	}

	// delete table 删除表
	static void drop(SQLiteDatabase db, String Table_name) {
		// ɾ�����SQL���
		String sql = "DROP TABLE " + Table_name;
		// ִ��SQL
		db.execSQL(sql);
	}
}
