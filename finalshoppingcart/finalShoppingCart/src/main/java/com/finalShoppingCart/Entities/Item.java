package com.finalShoppingCart.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="item entity",description="item")
public class Item {

	@ApiModelProperty(value="the item ID")
	@Id
	@GeneratedValue
	private int itemId;
	
	@ApiModelProperty(value="the item name")
	private String itemName;
	
	@ApiModelProperty(value="the item price")
	private double itemPrice;
	
	@ApiModelProperty(value="the item stock")
	private int itemStock;
	
	@ApiModelProperty(value="the item type")
	@JoinColumn(name="typeId")
	@ManyToOne
	private Type itemType;
	
	public Item (int itemID, String itemName,double itemPrice,int itemStock,Type itemType){
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemStock=itemStock;
		this.itemType=itemType;
	}
	
	public int getItemId (){
		return itemId;
	}
	
	public void setItemId(int itemId){
		this.itemId=itemId;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	
	public double getItemPrice(){
		return itemPrice;
	}
	
	public void setItemPrice(double itemPrice){
		this.itemPrice=itemPrice;
	}
	
	public int getItemStock(){
		return itemStock;
	}
	
	public void setItemStock(int itemStock){
		this.itemStock=itemStock;
	}
	
	public Type getItemType(){
		return itemType;
	}
	
	public void setItemType(Type itemType){
		this.itemType=itemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + itemStock;
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
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
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		if (itemStock != other.itemStock)
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemStock="
				+ itemStock + ", itemType=" + itemType + "]";
	}
	

}