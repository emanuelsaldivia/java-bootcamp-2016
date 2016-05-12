package com.bootcamp.topic6.classes;

public class User {

	private int userId;
	private String userName;
	private String userPassword;
	
	public User(int userId,String userName,String userPassword){
		this.userId=userId;
		this.userName=userName;
		this.userPassword=userPassword;
	}
	
	public void setUserId(int userId){
		this.userId=userId;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}
	
	public String getUserPassword(){
		return userPassword;
	}
	
	@Override
	public String toString(){
		return "User \n"
				+ "Id: "+userId+"\n"
				+ "Name: "+userName;			
	}
}
