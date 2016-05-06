package com.bootcamp.Topic3.ShoppingCartAPI;

public interface ServiceShoppingCart {
	
	public boolean addItem(Item item);
	public boolean deleteItem (Item item);
	public Item getItem (int id);
	public Sale doCheckOut ();
	public void clearCart();

}
