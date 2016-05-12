package com.bootcamp.topic6.dao;

import com.bootcamp.topic6.classes.Item;

public interface ItemDAO {

	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public boolean updateItem(Item item);
	public Item getItem(int itemId);
}
