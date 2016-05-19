package com.finalShoppingCart.services;

import java.util.List;

import com.finalShoppingCart.Entities.Item;

public interface ItemService {

	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public boolean updateItem(Item item);
	public Item getItemById(int itemId);
	public List<Item> getItemByType(int typeId);
	public List<Item> getAllItems();
}
