package com.finalShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalShoppingCart.Entities.Type;
import com.finalShoppingCart.services.TypeService;

import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping("/types")
@Api(value="types",description="types of items")
public class TypeController {

	@Autowired
	TypeService typeService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Type> addType(@RequestBody Type type){
		typeService.addType(type);
		if (typeService.addType(type)){
			return new ResponseEntity<Type> (HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Type> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Type> deleteType(@RequestBody Type type){
		typeService.deleteType(type);
		if (typeService.deleteType(type)){
			return new ResponseEntity<Type> (HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Type> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Type> updateType(Type type){
		if (typeService.getTypeById(type.getTypeId())!=null){
			typeService.updateType(type);
			if (typeService.updateType(type)){
				return new ResponseEntity<Type> (HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Type> (HttpStatus.BAD_REQUEST);
			}
		}
		else{
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/type/{typeId}",method=RequestMethod.GET)
	public ResponseEntity<Type> getTypeById(@PathVariable int typeId){
		Type type = typeService.getTypeById(typeId);
		if (type!=null){
			return new ResponseEntity<Type> (type,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="type/{typeName}",method=RequestMethod.GET)
	public ResponseEntity<List<Type>> getTypeByName(@PathVariable String typeName){
		List<Type> types=typeService.getTypyeByName(typeName);
		if (types.isEmpty()==false){
			return new ResponseEntity<List<Type>>(types,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}