package com.bootcamp.topic6.classes;

import java.util.List;
import java.util.LinkedList;

import javax.persistence.Entity;

@Entity
public class Sale {

	private LinkedList<Item> shoppingCart;
	private  double totalSale=(double)0;
	
	public Sale(LinkedList<Item> shoppingCart2) {
		// TODO Auto-generated constructor stub
	}

	public void Sale (LinkedList<Item> shoppingCart){
		this.shoppingCart=shoppingCart;
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
