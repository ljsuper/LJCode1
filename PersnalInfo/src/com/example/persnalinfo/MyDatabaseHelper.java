package com.example.persnalinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	public MyDatabaseHelper(Context context,String dbName,int version){
		super(context, dbName, null, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("CREATE TABLE IF NOT EXISTS person" +
				"(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,address TEXT,"+
				"personalProfile TEXT,attention INTEGER,weibo INTEGER,interest INTEGER,"+
				"topic INTEGER)");
		Person person=new Person("","","",0,0,0,0);
		db.execSQL("INSERT INTO person VALUES(null,?,?,?,?,?,?,?)", new Object[]{
				person.getName(), person.getAddress(), person.getPersonalProfile(),
				person.getAttention(), person.getWeibo(), person.getInterest(),
				person.getTopic()});
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("ALTER TABLE person ADD COLUMN other STRING");
	}
}