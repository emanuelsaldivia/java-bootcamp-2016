package com.bootcamp.topic6.dao;

import org.springframework.stereotype.Service;

import com.bootcamp.topic6.classes.User;

@Service
public class UserDAOImp implements UserDAO {

	Mocke mockeDB;
	
	@Override
	public boolean addUser(User user) {
		return mockeDB.getAllUsers().add(user);
	}

	@Override
	public boolean deleteUser(User user) {
		return mockeDB.getAllUsers().remove(user);
	}

	@Override
	public boolean updateUser(User user) {
		for (int i=0;i<mockeDB.getAllUsers().size();i++){
			if (mockeDB.getAllUsers().get(i).equals(user)){
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUser(int userId) {
		return mockeDB.findUser(userId);
	}
}
