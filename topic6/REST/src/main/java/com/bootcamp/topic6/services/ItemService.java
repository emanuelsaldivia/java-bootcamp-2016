package com.bootcamp.topic6.services;

import com.bootcamp.topic6.classes.Item;

public interface ItemService {

	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public boolean updateItem(Item item);
	public Item getItem(int itemId);
}
