package com.finalShoppingCart.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalShoppingCart.Entities.Type;
import com.finalShoppingCart.dao.TypeDAO;
import com.finalShoppingCart.dao.TypeDAOImp;
import com.finalShoppingCart.services.TypeService;

@Service
public class TypeServiceImp implements TypeService {

	@Autowired
	private TypeDAO typeDAO;
	
	public TypeServiceImp(){
		typeDAO= new TypeDAOImp();
	}
	
	/**
	 * this is a not specified method to add types
	 */
	@Override
	public boolean addType(Type type) {
		//typeDAO.addType(Type type);  supposing we have this method in the dao
		return false;
	}

	/**
	 * this is a not specified method to delete types
	 */
	@Override
	public boolean deleteType(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * this is a not specified method to update types
	 */
	@Override
	public boolean updateType(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getTypeById(int typeId) {
		return typeDAO.getTypeById(typeId);
	}

	@Override
	public List<Type> getTypyeByName(String typeName) {
		return typeDAO.getTypeByName(typeName);
	}

}
