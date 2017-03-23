package com.example.btphone.db;

import java.util.ArrayList;

import com.example.btphone.bean.ContactInfo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BtPhoneDB {
	// calltype:
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

	// 删除通讯录
	public static void delete_phonebook(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num) {
		// ʵ��������ֵ
		ContentValues cValue = new ContentValues();
		String[] args = { Phone_name, Phone_num };
		db.delete(Table_name, "phonename=? and phonenumber=?", args);
		//
		// 删除SQL语句
		// String sql = "delete from " + Table_name + " where phonename  = "
		// + Phone_name + "and phonenumber = " + Phone_num;
		//
		// 01-01 03:13:50.790: E/AndroidRuntime(988):
		// android.database.sqlite.SQLiteException: near "phonenumber": syntax
		// error (code 1): , while compiling: delete from phonebook where
		// phonename = 我的编号and phonenumber = +8618503080088

		// 执行SQL语句
		// db.execSQL(sql);

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

	// 删除通话记录
	public static void delete_calllog(SQLiteDatabase db, String Table_name, String Phone_name, String Phone_num, int calltype, String time) {
		ContentValues cValue = new ContentValues();
		String[] args = { Phone_name, Phone_num, calltype + "" };
		db.delete(Table_name, "phonename=? and phonenumber=? and calltype=?", args);
	}

	// search name with num 查询联系人
	public static String queryPhoneName(SQLiteDatabase db, String Table_name, String Phone_num) {
		// ��ѯ����α�
		// ����1������
		// ����2��Ҫ����ʾ����
		// ����3��where�Ӿ�
		// ����4��where�Ӿ��Ӧ������ֵ
		// ����5�����鷽ʽ
		// ����6��having����
		// ����7������ʽ
		String Phonename;
		String Phonenum;
		Cursor cursor = db.query("phonebook", new String[] { "phonename", "phonenumber" }, "phonenumber= ?", new String[] { Phone_num }, null, null, null); // "ORDEY BY ASC"

		int count = cursor.getCount();

		while (cursor.moveToNext()) {
			Phonenum = cursor.getString(cursor.getColumnIndex("phonenumber"));

			Phonename = cursor.getString(cursor.getColumnIndex("phonename"));
			return Phonename;
		}

		return null;
	}

	/**
	 * @Title getUserListFromDatabases
	 * @Description �����ݿ��еõ���ʷ��¼����Ϣ
	 * @param sql
	 * @param args
	 * @return
	 * @Return ArrayList<User> ��������
	 * @Throws
	 */
	// 查询所有电话联系人
	public static ArrayList<ContactInfo> queryAllPhoneName(SQLiteDatabase db, String Table_name) {
		ArrayList<ContactInfo> dataList = new ArrayList<ContactInfo>();
		Log.d(TAG, "" + (db == null));
		if (db == null) {
			return null;
		}
		Cursor cursor = db.query("phonebook", new String[] { "phonename", "phonenumber" }, "", new String[] {}, null, null, null); // "ORDEY BY ASC"

		int count = cursor.getCount();

		while (cursor.moveToNext()) {
			ContactInfo info = new ContactInfo();
			info.setName(cursor.getString(cursor.getColumnIndex("phonename")));
			info.setPhoneNum(cursor.getString(cursor.getColumnIndex("phonenumber")));
			dataList.add(info);
		}
		return dataList;
	}

	// 查询所有通话记录
	public static void queryCallLog(SQLiteDatabase db, String CallType) {
		// ��ѯ����α�
		// ����1������
		// ����2��Ҫ����ʾ����
		// ����3��where�Ӿ�
		// ����4��where�Ӿ��Ӧ������ֵ
		// ����5�����鷽ʽ
		// ����6��having����
		// ����7������ʽ
		String Phonename;
		String Phonenum;
		String time;
		Cursor cursor = db.query("calllog", new String[] { "phonename", "phonenumber", "time" }, "calltype=?", new String[] { CallType }, null, null, null); // "ORDEY BY ASC"

		int count = cursor.getCount();

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
