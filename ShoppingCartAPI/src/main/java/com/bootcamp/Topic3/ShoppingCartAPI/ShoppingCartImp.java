package com.bootcamp.Topic3.ShoppingCartAPI;

import java.util.List;
import java.util.LinkedList;

public class ShoppingCartImp implements ServiceShoppingCart {

	private LinkedList<Item> shoppingCart;
	
	public ShoppingCartImp (){
		shoppingCart= new LinkedList<Item>();
	}
	
	public boolean addItem (Item item){
		return shoppingCart.add(item);
	}
	
	public boolean deleteItem (Item item){
		return shoppingCart.remove(item);
	}
	
	public Item getItem (int id){
		return shoppingCart.get(id);
	}
	
	public Sale doCheckOut (){
		return new Sale (shoppingCart);
	}
	
	public void clearCart(){
		shoppingCart.clear();
	}
	
	
}
