package com.example.personal_information;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("WorldReadableFiles")
public class MainActivity extends Activity {

	private ImageView mycontact_iamgeIcon;
	private EditText mycontact_editName;
	private Button mycontact_editBtn;
	private EditText mycontact_address;
	private EditText mycontact_loginName;
	private TextView mycontact_item_attention;
	private TextView mycontact_item_weibo;
	private TextView mycontact_item_interest;
	private TextView mycontact_item_topic;
	private TextView head_userName;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	private int attention;
	private int weibo;
	private int interest;
	private int topic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		head_userName = (TextView)findViewById(R.id.head_userName);
		head_userName.setText(R.string.head_text);

		mycontact_editName = (EditText) findViewById(R.id.mycontact_editName);
		mycontact_iamgeIcon = (ImageView)findViewById(R.id.mycontact_iamgeIcon);
		mycontact_editBtn = (Button)findViewById(R.id.mycontact_editBtn);
		mycontact_address = (EditText)findViewById(R.id.mycontact_address);
		mycontact_loginName = (EditText)findViewById(R.id.mycontact_loginName);
		mycontact_item_attention = (TextView)findViewById(R.id.mycontact_item_attention);
		mycontact_item_weibo = (TextView)findViewById(R.id.mycontact_item_weibo);
		mycontact_item_interest = (TextView)findViewById(R.id.mycontact_item_interest);
		mycontact_item_topic = (TextView)findViewById(R.id.mycontact_item_topic);
		
		preferences=getSharedPreferences("personalinfo",MODE_WORLD_READABLE);
		editor=preferences.edit();
		
		readInfo();
		
		mycontact_editBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				editInfo();
			}
		});
		
	}
	
	public void readInfo(){
		String editName=preferences.getString("mycontact_editName", "");
		String address=preferences.getString("mycontact_address", "");
		String loginName=preferences.getString("mycontact_loginName", "");
		attention=preferences.getInt("mycontact_item_attention", 0);
		weibo=preferences.getInt("mycontact_item_weibo", 0);
		interest=preferences.getInt("mycontact_item_interest", 0);
		topic=preferences.getInt("mycontact_item_topic", 0);
		
		mycontact_editName.setText(editName);
		mycontact_address.setText(address);
		mycontact_loginName.setText(loginName);
		mycontact_item_attention.setText(Integer.toString(attention));
		mycontact_item_weibo.setText(Integer.toString(weibo));
		mycontact_item_interest.setText(Integer.toString(interest));
		mycontact_item_topic.setText(Integer.toString(topic));
	}
	
	public void editInfo(){
		editor.putString("mycontact_editName",mycontact_editName.getText().toString() );
		editor.putString("mycontact_address",mycontact_address.getText().toString() );
		editor.putString("mycontact_loginName",mycontact_loginName.getText().toString() );
		editor.putInt("mycontact_item_attention", attention+1);
		editor.putInt("mycontact_item_weibo", weibo+2);
		editor.putInt("mycontact_item_interest", interest+3);
		editor.putInt("mycontact_item_topic", topic+4);
		editor.commit();
	}
}

