package com.bootcamp.Topic3.ShoppingCartAPI;

import java.util.LinkedList;

public class UserImp implements ServiceUser {

	public String userName;
	public String userPassword;
	ServiceShoppingCart shoppingCart = ShoppingCartFactory.getShoppingCart();
	
	public UserImp (String userName,String userPassword){
		this.userName=userName;
		this.userPassword=userPassword;
	}
	
	public void addItemToCart (Item item){
		shoppingCart.addItem(item);
	}
	
	public void deleteCartItem (Item item){
		shoppingCart.deleteItem(item);
	}
	
	public Item selectItem (int id){
		return shoppingCart.getItem(id);
	}
	
	public Sale checkOut (){
		return shoppingCart.doCheckOut();
	}
	
	public LinkedList<Item> showCart(){
		return shoppingCart.doCheckOut().getCart();
	}
	
	public double showTotal(){
		return shoppingCart.doCheckOut().getTotalSale();
	}

}
