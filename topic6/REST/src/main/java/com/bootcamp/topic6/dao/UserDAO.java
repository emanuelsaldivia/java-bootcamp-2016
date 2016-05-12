package com.bootcamp.topic6.dao;

import com.bootcamp.topic6.classes.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int userId);
}
