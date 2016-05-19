package com.finalShoppingCart.dao;

import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalShoppingCart.Entities.User;

@Service
public class UserDAOImp implements UserDAO {

	EntityManager manager;
	
	@Override
	@Transactional
	public boolean addUser(User user) {
		TypedQuery<User> query=(TypedQuery<User>) getManager().createQuery("INSERT INTO User u VALUES (itemId=, itemName=?,itemPrice=?,itemStock=?,typeId=?) WHERE itemId=?");
		query.setParameter(1, user.getUserId());
		query.setParameter(2,user.getUserName());
		query.setParameter(3, user.getUserPasswor());
		return query.equals(true);
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		TypedQuery<User> query=(TypedQuery<User>) getManager().createQuery("DELETE FROM User u WHERE u.userId=?");
		query.setParameter(1,user.getUserId());
		return query.equals(true);
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		TypedQuery<User> query=(TypedQuery<User>) getManager().createQuery("UPDATE User u SET (u.userId=?,u.userName=?,u.userPassword=?) WHERE u.userId=? ");
		query.setParameter(1, user.getUserId());
		query.setParameter(3, user.getUserName());
		query.setParameter(4, user.getUserPasswor());
		query.setParameter(5, user.getUserId());
		return query.equals(true);
	}

	@Override
	@Transactional
	public User getUserById(int userId) {
		TypedQuery<User> query=(TypedQuery<User>) getManager().createQuery("SELECT * FROM User u WHERE u.userid=?");
		query.setParameter(1, userId);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional
	public User getUserByName(String userName){
		TypedQuery<User> query=(TypedQuery) getManager().createQuery("SELECT u FROM User u WHERE u.userName=?");
		query.setParameter(1, userName);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional
	public List<User> getAllUsers(){
		TypedQuery<User> query=(TypedQuery<User>) getManager().createQuery("SELECT * FROM User");
		return query.getResultList();
	}

	public EntityManager getManager(){
		return manager;
	}
	
	public void setManager(EntityManager manager){
		this.manager=manager;
	}
}
