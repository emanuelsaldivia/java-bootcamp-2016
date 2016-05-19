package com.finalShoppingCart.dao;

import java.util.List;

import com.finalShoppingCart.Entities.Type;

public interface TypeDAO {

	public Type getTypeById(int typeId);
	public List<Type> getTypeByName(String typeName);
	public List<Type> getAllTypes();
	
}
