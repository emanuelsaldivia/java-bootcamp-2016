package com.bootcamp.topic6.dao;

import java.util.LinkedList;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.User;

public class Mocke {

	private static LinkedList<Item> items;
	private static LinkedList<User> users;
	
	public static Item findItem (int itemId){
		init();
		for (int i=0;i<items.size();i++){
			if (items.get(i).getItemId()==itemId){
				return items.get(i);
			}
		}
		return null;
	}
	
	public static User findUser(int userId){
		init();
		for (int i=0;i<users.size();i++){
			if (users.get(i).getUserId()==userId){
				return users.get(i);
			}
		}
		return null;
	}
	
	public static LinkedList<Item> getAllItems(){
		init();
		return items;
	}
	
	public static LinkedList<User> getAllUsers(){
		init();
		return users;
	}
	private static void init(){
		if(items.isEmpty()) initItems();
		if(users.isEmpty()) initUsers();
	}
	
	private static void initItems(){
		items.add(new Item("item 1",(double) 1,100));
		items.add(new Item("item 2",(double) 2,100));
		items.add(new Item("item 3",(double) 3,100));
	}
	
	private static void initUsers(){
		users.add(new User(1,"user 1","password"));
		users.add(new User(2,"user 2","password"));
		users.add(new User(3,"user 3","password"));
	}
}
