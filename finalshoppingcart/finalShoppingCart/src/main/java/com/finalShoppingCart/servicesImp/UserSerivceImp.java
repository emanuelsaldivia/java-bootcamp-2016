package com.finalShoppingCart.servicesImp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalShoppingCart.Entities.Item;
import com.finalShoppingCart.Entities.Sale;
import com.finalShoppingCart.Entities.User;
import com.finalShoppingCart.dao.UserDAO;
import com.finalShoppingCart.dao.UserDAOImp;
import com.finalShoppingCart.services.UserSerivce;

@Service
public class UserSerivceImp implements UserSerivce {

	@Autowired
	UserDAO userDAO;
	
	public UserSerivceImp(){
		userDAO=new UserDAOImp();
	}

	@Override
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public boolean deleteUser(User user) {
		return userDAO.deleteUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}

	@Override
	public User getUserByName(String userName){
		return userDAO.getUserByName(userName);
	}
	
	@Override
	public User validateUser(String userName,String userPass) throws Exception{
		if(!userDAO.getUserByName(userName).equals(null)){
			if(userDAO.getUserByName(userName).getUserName().equals(userName)){
				if(userDAO.getUserByName(userName).getUserPasswor().equals(userPass)){
					return userDAO.getUserByName(userName);
				}
				else{
					throw new Exception("incorrect Password");
				}
			}
			else{
				throw new Exception("User "+userName+" doesn't exists");
			}
		}
		return null;
	}
}
