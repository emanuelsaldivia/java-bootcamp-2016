package com.bootcamp.Topic3.ShoppingCartAPI;

public class ShoppingCartFactory {

	public static ServiceShoppingCart getShoppingCart(){
		return new ShoppingCartImp();
	}
}
