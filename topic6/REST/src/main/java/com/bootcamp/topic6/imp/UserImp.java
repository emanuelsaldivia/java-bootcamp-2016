package com.bootcamp.topic6.imp;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.Sale;
import com.bootcamp.topic6.classes.User;
import com.bootcamp.topic6.dao.UserDAO;
import com.bootcamp.topic6.dao.UserDAOImp;
import com.bootcamp.topic6.factories.ShoppingCartFactory;
import com.bootcamp.topic6.services.ShoppingCartService;
import com.bootcamp.topic6.services.UserService;

@Service
public class UserImp implements UserService {

	private UserDAO userDAO;
	
	public UserImp(){
		userDAO=new UserDAOImp();
	}
	ShoppingCartService shoppingCart = ShoppingCartFactory.getShoppingCart();
	
	@Override
	public void addItemToCart (Item item){
		shoppingCart.addItem(item);
	}
	
	@Override
	public void deleteCartItem (Item item){
		shoppingCart.deleteItem(item);
	}
	
	@Override
	public Item selectItem (int id){
		return shoppingCart.getItem(id);
	}
	
	@Override
	public Sale checkOut (){
		return shoppingCart.doCheckOut();
	}
	
	@Override
	public LinkedList<Item> showCart(){
		return shoppingCart.doCheckOut().getCart();
	}
	
	@Override
	public double showTotal(){
		return shoppingCart.doCheckOut().getTotalSale();
	}
	
	@Override
	public boolean addUser(User user){
		return userDAO.addUser(user);
	}
	
	@Override
	public boolean deleteUser(User user){
		return userDAO.deleteUser(user);
	}
	
	@Override
	public boolean updateUser(User user){
		return userDAO.updateUser(user);
	}
	
	@Override
	public User getUser(int userId){
		return userDAO.getUser(userId);
	}
}
