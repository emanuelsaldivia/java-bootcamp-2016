package com.finalShoppingCart.dao;

import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalShoppingCart.Entities.Item;

@Service
public class ItemDAOImp implements ItemDAO {
	EntityManager manager;
	
	@Override
	@Transactional
	public boolean addItem(Item item) {
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("INSERT INTO Item i VALUES (itemId=, itemName=?,itemPrice=?,itemStock=?,typeId=?) WHERE itemId=?");
		query.setParameter(1, item.getItemId());
		query.setParameter(2, item.getItemName());
		query.setParameter(3, item.getItemPrice());
		query.setParameter(4, item.getItemStock());
		query.setParameter(5, item.getItemType().getTypeId());
		query.setParameter(6, item.getItemId());
		return query.equals(true);
	}

	@Override
	@Transactional
	public boolean deleteItem(Item item) {
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("Delete FROM Item WHERE itemId=?");
		query.setParameter(1, item.getItemId());
		return query.equals(true);
	}

	@Override
	@Transactional
	public boolean updateItem(Item item) {
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("UPDATE Item SET (itemId=, itemName=?,itemPrice=?,itemStock=?,typeId=?) WHERE itemId=?");
		query.setParameter(1, item.getItemId());
		query.setParameter(2, item.getItemName());
		query.setParameter(3, item.getItemPrice());
		query.setParameter(4, item.getItemStock());
		query.setParameter(5, item.getItemType().getTypeId());
		query.setParameter(6, item.getItemId());
		return true;
	}

	@Override
	@Transactional
	public Item getItemById(int itemId) {
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("SELECT * FROM Item i WHERE i.itemId= :?");
		query.setParameter(1,itemId);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional
	public List<Item> getItemByType(int typeId){
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("SELECT * FROM Item i WHERE i.itemId=?");
		query.setParameter(1, typeId);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Item> getAllItems(){
		TypedQuery<Item> query=(TypedQuery<Item>) getManager().createQuery("SELECT * FROM Item");
		return query.getResultList();
	}
	
	public EntityManager getManager(){
		return manager;
	}
	
	public void setManager(EntityManager manager){
		this.manager=manager;
	}

}