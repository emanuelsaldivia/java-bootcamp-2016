package com.finalShoppingCart.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalShoppingCart.Entities.Item;
import com.finalShoppingCart.dao.ItemDAO;
import com.finalShoppingCart.dao.ItemDAOImp;
import com.finalShoppingCart.services.ItemService;

@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	public ItemServiceImp (){
	itemDAO= new ItemDAOImp();
	}
	
	@Override
	public boolean addItem(Item item) {
		return itemDAO.addItem(item);
	}

	@Override
	public boolean deleteItem(Item item) {
		return itemDAO.deleteItem(item);
	}

	@Override
	public boolean updateItem(Item item) {
		return itemDAO.updateItem(item);
	}

	@Override
	public Item getItemById(int itemId) {
		return itemDAO.getItemById(itemId);
	}

	@Override
	public List<Item> getItemByType(int typeId) {
		return itemDAO.getItemByType(typeId);
	}
	
	@Override
	public List<Item> getAllItems(){
		return itemDAO.getAllItems();
	}

}
