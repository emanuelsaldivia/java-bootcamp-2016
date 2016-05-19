package com.finalShoppingCart.dao;

import java.util.List;

import com.finalShoppingCart.Entities.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser (User user);
	public User getUserById(int userId);
	public User getUserByName(String userName);
	public List<User> getAllUsers();	
}