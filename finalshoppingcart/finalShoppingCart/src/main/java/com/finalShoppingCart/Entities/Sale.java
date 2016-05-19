package com.finalShoppingCart.Entities;

import java.sql.Date;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="sale entity",description="sale")
public class Sale {

	@ApiModelProperty(value="the sale Id")
	@Id
	@GeneratedValue
	private int saleId;
	
	@ApiModelProperty(value= "user owner of the saled cart")
	@ManyToOne
	@JoinColumn(name="userId")
	private User saleUser;
	
	@ApiModelProperty(value="the sale date")
	private Date saleDate;
	
	@ApiModelProperty(value="the sale list of products")
	private LinkedList<Item> saleCart;
	
	@ApiModelProperty(value="the total sale")
	private double totalSale;
	
	public Sale (User saleUser,Date saleDate,LinkedList<Item> saleCart){
		super();
		this.saleUser=saleUser;
		this.saleDate=saleDate;
		this.saleCart=saleCart;
		this.totalSale=(double)0;
		for (Item item: saleCart){
			this.totalSale+=item.getItemPrice();
		}
	}
	
	public int getSaleId(){
		return saleId;
	}
	
	public User getSaleUser(){
		return saleUser;
	}
	
	public void setSaleUser(User saleUser){
		this.saleUser=saleUser;
	}
	
	public Date getSaleDate(){
		return saleDate;
	}
	
	public void setSaleDate(Date saleDate){
		this.saleDate=saleDate;
	}
	
	public LinkedList<Item> getSaleCart(){
		return saleCart;
	}
	
	public void setSaleCart(LinkedList<Item> saleCart){
		this.saleCart=saleCart;
	}
	
	public double getTotalSale(){
		return totalSale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((saleCart == null) ? 0 : saleCart.hashCode());
		result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
		result = prime * result + saleId;
		result = prime * result + ((saleUser == null) ? 0 : saleUser.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalSale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Sale other = (Sale) obj;
		if (saleCart == null) {
			if (other.saleCart != null)
				return false;
		} else if (!saleCart.equals(other.saleCart))
			return false;
		if (saleDate == null) {
			if (other.saleDate != null)
				return false;
		} else if (!saleDate.equals(other.saleDate))
			return false;
		if (saleId != other.saleId)
			return false;
		if (saleUser == null) {
			if (other.saleUser != null)
				return false;
		} else if (!saleUser.equals(other.saleUser))
			return false;
		if (Double.doubleToLongBits(totalSale) != Double.doubleToLongBits(other.totalSale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", saleUser=" + saleUser + ", saleDate=" + saleDate + ", saleCart=" + saleCart
				+ ", totalSale=" + totalSale + "]";
	}
	

}
