package com.example.persnalinfo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ImageView mycontact_iamgeIcon;
	private Button mycontact_editBtn;
	private EditText mycontact_editName;
	private EditText mycontact_address;
	private EditText mycontact_personalProfile;
	private TextView mycontact_item_attention;
	private TextView mycontact_item_weibo;
	private TextView mycontact_item_interest;
	private TextView mycontact_item_topic;
	private TextView head_userName;
	private int personID;
	private int attention;
	private int weibo;
	private int interest;
	private int topic;
	private MyDatabaseHelper dbHelper;
	private SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
		
		readInfo();
		
		mycontact_editBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				editInfo();
			}
		});

	}
	
	public void init(){
		head_userName = (TextView)findViewById(R.id.head_userName);
		head_userName.setText(R.string.head_text);

		mycontact_editName = (EditText) findViewById(R.id.mycontact_editName);
		mycontact_iamgeIcon = (ImageView)findViewById(R.id.mycontact_iamgeIcon);
		mycontact_editBtn = (Button)findViewById(R.id.mycontact_editBtn);
		mycontact_address = (EditText)findViewById(R.id.mycontact_address);
		mycontact_personalProfile = (EditText)findViewById(R.id.mycontact_personalProfile);
		mycontact_item_attention = (TextView)findViewById(R.id.mycontact_item_attention);
		mycontact_item_weibo = (TextView)findViewById(R.id.mycontact_item_weibo);
		mycontact_item_interest = (TextView)findViewById(R.id.mycontact_item_interest);
		mycontact_item_topic = (TextView)findViewById(R.id.mycontact_item_topic);
		
		dbHelper= new MyDatabaseHelper(this, "personInfo.db", 1);
		db=dbHelper.getReadableDatabase();
		}
	
	public void readInfo(){
		Cursor c = db.rawQuery("SELECT * FROM person", null); 
		c.moveToFirst();
		Person person = new Person();   
        person.setName(c.getString(c.getColumnIndex("name")));
        person.setAddress(c.getString(c.getColumnIndex("address")));
        person.setPersonalProfile(c.getString(c.getColumnIndex("personalProfile")));
        person.setAttention(c.getInt(c.getColumnIndex("attention")));
        person.setWeibo(c.getInt(c.getColumnIndex("weibo")));
        person.setInterest(c.getInt(c.getColumnIndex("interest")));
        person.setTopic(c.getInt(c.getColumnIndex("topic")));
        
        personID=c.getInt(c.getColumnIndex("_id"));
		attention=c.getInt(c.getColumnIndex("attention"));
		weibo=c.getInt(c.getColumnIndex("weibo"));
		interest=c.getInt(c.getColumnIndex("interest"));
		topic=c.getInt(c.getColumnIndex("topic"));
        
        c.close();
        
        mycontact_editName.setText(person.getName());
		mycontact_address.setText(person.getAddress());
		mycontact_personalProfile.setText(person.getPersonalProfile());
		mycontact_item_attention.setText(Integer.toString(person.getAttention()));
		mycontact_item_weibo.setText(Integer.toString(person.getWeibo()));
		mycontact_item_interest.setText(Integer.toString(person.getInterest()));
		mycontact_item_topic.setText(Integer.toString(person.getTopic()));
	}
	

	public void editInfo(){
		Person person = new Person(); 
		person.setName(mycontact_editName.getText().toString());
		person.setAddress(mycontact_address.getText().toString());
		person.setPersonalProfile(mycontact_personalProfile.getText().toString());
		person.setAttention(attention+1);
		person.setWeibo(weibo+2);
		person.setInterest(interest+3);
		person.setTopic(topic+4);
		
		ContentValues values = new ContentValues();
		values.put("name", person.getName());
		values.put("address", person.getAddress());
		values.put("personalProfile", person.getPersonalProfile());
		values.put("attention", person.getAttention());
		values.put("weibo", person.getWeibo());
		values.put("interest", person.getInterest());
		values.put("topic", person.getTopic());
		
		db.update("person", values, "_id="+personID, null);
	}
	
	public void onDestroy(){
		super.onDestroy();
		if(dbHelper!=null){
			dbHelper.close();
		}
	}
}


