package com.finalShoppingCart.Entities;

import java.sql.Date;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.joda.time.LocalDate;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel (value="ShoppingCart entity", description ="ShoppingCart")
public class ShoppingCart {

	@ApiModelProperty(value="ShoppingCart Id")
	@Id
	@GeneratedValue
	private int shoppingCartId;
	
	@ApiModelProperty(value="user owner of the cart")
	@OneToOne
	@JoinColumn(name="userId")
	private User shoppingCartUser;
	
	@ApiModelProperty(value="items on the cart")
	private LinkedList<Item> items;
	
	public int getShoppingCartId(){
		return shoppingCartId;
	}
	
	public User getShoppingCartUser(){
		return shoppingCartUser;
	}
	
	public LinkedList<Item> getShoppingCartItems(){
		return items;
	}
	
	public void setShoppingCartItems(LinkedList<Item> items){
		this.items=items;
	}
	
	public Item getShoppingCartItem(int itemId){
		for (Item item:items){
			if (item.getItemId()==itemId){
				return items.get(itemId);
			}
		}
		return null;
	}
	
	public boolean addItemToCart(Item item){
		return items.add(item);
	}
	
	public boolean deleteItemFromCart(Item item){
		return items.remove(item);
	}
	
	public void clearItems(){
		items.clear();
	}
	
	public Sale checkOut(){
		Sale sale= new Sale(shoppingCartUser,Date.valueOf(LocalDate.now()),items);
		items.clear();
		return sale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + shoppingCartId;
		result = prime * result + ((shoppingCartUser == null) ? 0 : shoppingCartUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (shoppingCartId != other.shoppingCartId)
			return false;
		if (shoppingCartUser == null) {
			if (other.shoppingCartUser != null)
				return false;
		} else if (!shoppingCartUser.equals(other.shoppingCartUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartId=" + shoppingCartId + ", shoppingCartUser=" + shoppingCartUser + ", items="
				+ items + "]";
	}
	
	
}
