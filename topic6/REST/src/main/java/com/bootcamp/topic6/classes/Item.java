package com.bootcamp.topic6.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id; 

@Entity
public class Item {

	private static int idGenerator=0;
	
//	@Id
//	@GeneratedValue
	private int itemId;
	
	private String itemName;
	private double itemPrice;
	private int itemQuantitie;
	
	public Item (String itemName, double itemPrice, int itemQuantitie){
		
		this.itemId=idGenerator++;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemQuantitie=itemQuantitie;
	}
	
	public int getItemId () {
		return itemId;
	}
	
	public String getItemName (){
		return itemName;
	}
	
	public double getItemPrice(){
		return itemPrice;
	}
	
	public int getItemQuantitie(){
		return itemQuantitie;
	}
	
	public double getFinalItemPrice (){
		return itemPrice*(double)itemQuantitie;
	}
	
	@Override
	public String toString(){
		return "Item\n "+ 
				"Id: "+itemId+
				"\n Name: "+itemName+
				"\n Price: "+itemPrice+
				"\n Quantitie: "+itemQuantitie;
	}
	
}
