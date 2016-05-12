package com.bootcamp.topic6.services;

import java.util.LinkedList;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.Sale;
import com.bootcamp.topic6.classes.User;

public interface UserService {

	public void addItemToCart(Item item);
	public void deleteCartItem(Item item);
	public Item selectItem (int id);
	public Sale checkOut();
	public LinkedList<Item> showCart();
	public double showTotal();
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int userId);
}
