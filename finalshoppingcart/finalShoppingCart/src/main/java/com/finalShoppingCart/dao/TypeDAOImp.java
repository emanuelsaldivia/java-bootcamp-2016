package com.finalShoppingCart.dao;

import java.util.List;

import com.finalShoppingCart.Entities.Type;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeDAOImp implements TypeDAO {

	EntityManager manager;
	
	@Override
	@Transactional
	public Type getTypeById(int typeId) {
		TypedQuery<Type> query=(TypedQuery<Type>) getManager().createQuery("SELECT * FROM Type t WHERE t.typeID=?");
		query.setParameter(1, typeId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public List<Type> getTypeByName(String typeName) {
		TypedQuery<Type> query=(TypedQuery<Type>) getManager().createQuery("SELECT * FROM Type t WHERE t.typeName=?");
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public List<Type> getAllTypes (){
		TypedQuery<Type> query=(TypedQuery<Type>) getManager().createQuery("SELECT * FROM Type");
		return query.getResultList();
	}

	public EntityManager getManager(){
		return manager;
	}
	
	public void setManager(EntityManager manager){
		this.manager=manager;
	}
}
