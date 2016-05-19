package com.finalShoppingCart.Entities;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="user entity",description="user")
public class User {

	@ApiModelProperty(value="the user Id") 
	@Id
	@GeneratedValue
	private int userId;
	
	@ApiModelProperty(value="the user name")
	private String userName;
	
	@ApiModelProperty(value="the user password")
	private String userPassword;
	
	@ApiModelProperty(value="the user cart")
	@OneToOne
	private ShoppingCart cart;
	
	@ApiModelProperty(value="the user's sales")
	@OneToMany
	private LinkedList<Sale> userSales;
	
	public User (String userName,String userPassword){
		this.userName=userName;
		this.userPassword=userPassword;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserPasswor(){
		return userPassword;
	}
	
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}
	
	public ShoppingCart getCart(){
		return cart;
	}
	
	public void setCart(ShoppingCart cart){
		this.cart=cart;
	}
	
	public LinkedList<Sale> getUserSales(){
		return userSales;
	}
	
	public void setUserSales(LinkedList<Sale> userSales){
		this.userSales=userSales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userSales == null) ? 0 : userSales.hashCode());
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
		User other = (User) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userSales == null) {
			if (other.userSales != null)
				return false;
		} else if (!userSales.equals(other.userSales))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", cart=" + cart
				+ ", userSales=" + userSales + "]";
	}
	

}
