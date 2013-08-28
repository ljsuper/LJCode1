package com.example.persnalinfo;

public class Person{
	private String name;
	private String address;
	private String personalProfile;
	private int attention;
	private int weibo;
	private int interest;
	private int topic;
	
	public Person(){
		
	}
	
	public Person(String name,String address,String personalProfile,int attention,
			int weibo,int interest, int topic){
		this.name=name;
		this.address=address;
		this.personalProfile=personalProfile;
		this.attention=attention;
		this.weibo=weibo;
		this.interest=interest;
		this.topic=topic;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getPersonalProfile(){
		return personalProfile;
	}
	
	public void setPersonalProfile(String personalProfile){
		this.personalProfile=personalProfile;
	}
	
	public int getAttention(){
		return attention;
	}
	
	public void setAttention(int attention){
		this.attention=attention;
	}
	
	public int getWeibo(){
		return weibo;
	}
	
	public void setWeibo(int weibo){
		this.weibo=weibo;
	}
	
	public int getInterest(){
		return interest;
	}
	
	public void setInterest(int interest){
		this.interest=interest;
	}
	
	public int getTopic(){
		return topic;
	}
	
	public void setTopic(int topic){
		this.topic=topic;
	}
}