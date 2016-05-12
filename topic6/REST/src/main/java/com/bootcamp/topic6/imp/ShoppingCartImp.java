package com.bootcamp.topic6.imp;

import java.util.List;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.bootcamp.topic6.services.ShoppingCartService;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.Sale;
import com.bootcamp.topic6.dao.ItemDAO;
import com.bootcamp.topic6.dao.ItemDAOImp;


@Service
public class ShoppingCartImp implements ShoppingCartService {

	private LinkedList<Item> shoppingCart;
	private ItemDAO itemDAO;

	public void ShopingCartImp (){
		shoppingCart= new LinkedList<Item>();
		itemDAO= new ItemDAOImp();
	}
	
	@Override
	public boolean addItem (Item item){
		return shoppingCart.add(itemDAO.getItem(item.getItemId()));
	}
	
	@Override
	public boolean deleteItem (Item item){
		return shoppingCart.remove(itemDAO.getItem(item.getItemId()));
	}
	
	@Override
	public Item getItem (int id){
		return shoppingCart.get(id);
	}
	
	@Override
	public Sale doCheckOut (){
		return new Sale (shoppingCart);
	}
	
	@Override
	public void clearCart(){
		shoppingCart.clear();
	}
	
	@Override
	public LinkedList<Item> showCart(){
		return shoppingCart;
	}
}
