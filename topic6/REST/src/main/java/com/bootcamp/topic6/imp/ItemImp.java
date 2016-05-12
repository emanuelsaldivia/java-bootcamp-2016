package com.bootcamp.topic6.imp;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.dao.ItemDAO;
import com.bootcamp.topic6.dao.ItemDAOImp;
import com.bootcamp.topic6.services.ItemService;

public class ItemImp implements ItemService {

	private ItemDAO itemDAO;
	
	public ItemImp(){
		itemDAO=new ItemDAOImp();
	}
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Item getItem(int itemId) {
		return itemDAO.getItem(itemId);
	}

}
