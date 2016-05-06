package com.bootcamp.Topic3.ShoppingCartAPI;

import java.util.LinkedList;

public interface ServiceUser {

	public void addItemToCart(Item item);
	public void deleteCartItem(Item item);
	public Item selectItem (int id);
	public Sale checkOut();
	public LinkedList<Item> showCart();
	public double showTotal();
}
