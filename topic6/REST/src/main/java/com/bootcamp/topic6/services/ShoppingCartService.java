package com.bootcamp.topic6.services;

import java.util.LinkedList;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.Sale;

public interface ShoppingCartService {

	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public Item getItem(int id);
	public Sale doCheckOut();
	public void clearCart();
	public LinkedList<Item> showCart();
	
}
