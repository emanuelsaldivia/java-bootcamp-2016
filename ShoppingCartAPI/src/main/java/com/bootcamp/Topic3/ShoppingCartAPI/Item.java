package com.bootcamp.Topic3.ShoppingCartAPI;

public class Item {

	public static int idGenerator=0;
	public int itemId;
	public String itemName;
	public double itemPrice;
	public int itemQuantitie;
	
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
		return "Item\n Id: "+itemId+"\n Name: "+itemName+"\n Price: "+itemPrice+"\n Quantitie: "+itemQuantitie;
	}
}
