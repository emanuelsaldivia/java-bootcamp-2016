package com.bootcamp.topic6.factories;

import com.bootcamp.topic6.imp.ShoppingCartImp;
import com.bootcamp.topic6.services.ShoppingCartService;

public class ShoppingCartFactory {

	public static ShoppingCartService getShoppingCart(){
		return new ShoppingCartImp();
	}
	
}
