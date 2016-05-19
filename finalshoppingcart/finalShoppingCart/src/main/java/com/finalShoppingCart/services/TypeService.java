package com.finalShoppingCart.services;

import java.util.List;

import com.finalShoppingCart.Entities.Type;

public interface TypeService {

	public boolean addType(Type type);
	public boolean deleteType(Type type);
	public boolean updateType(Type type);
	public Type getTypeById(int typeId);
	public List<Type> getTypyeByName(String typeName);
}
