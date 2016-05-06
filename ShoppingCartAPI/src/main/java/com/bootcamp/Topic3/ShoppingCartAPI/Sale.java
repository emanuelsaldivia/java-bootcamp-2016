package com.bootcamp.Topic3.ShoppingCartAPI;

import java.util.LinkedList;

public class Sale {

	public LinkedList<Item> shoppingCart;
	public double totalSale=0;
	
	public Sale(LinkedList<Item> shoppingCart){
		this.shoppingCart= shoppingCart;
	}
	
	public double getTotalSale(){
		for (int i=0;i<shoppingCart.size();i++){
			totalSale+=shoppingCart.get(i).getFinalItemPrice();
		}
		return totalSale;
	}
	
	public LinkedList<Item> getCart (){
		return shoppingCart;
	}
	
}
