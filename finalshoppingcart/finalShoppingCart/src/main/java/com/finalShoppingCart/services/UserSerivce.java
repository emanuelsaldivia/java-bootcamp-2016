package com.finalShoppingCart.services;

import java.util.LinkedList;
import java.util.List;

import com.finalShoppingCart.Entities.Item;
import com.finalShoppingCart.Entities.Sale;
import com.finalShoppingCart.Entities.User;

public interface UserSerivce {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUserById(int userId);
	public List<User> getAllUsers();
	public User getUserByName(String userName);
	public User validateUser(String userName,String userPass) throws Exception;
}
