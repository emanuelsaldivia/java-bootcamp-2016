package com.bootcamp.topic6.dao;

import org.springframework.stereotype.Service;

import com.bootcamp.topic6.classes.Item;

@Service
public class ItemDAOImp implements ItemDAO {

	Mocke mockeDB;
	
	@Override
	public boolean addItem (Item item){
		return mockeDB.getAllItems().add(item);
	}
	
	@Override
	public boolean deleteItem (Item item){
		return mockeDB.getAllItems().remove(item);
	}
	
	@Override
	public boolean updateItem (Item item){
		for (int i=0;i<mockeDB.getAllItems().size();i++){
			if (mockeDB.getAllItems().get(i).equals(item)){
				mockeDB.getAllItems().add(i, item);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Item getItem(int itemId){
		return mockeDB.findItem(itemId);
	}
}
