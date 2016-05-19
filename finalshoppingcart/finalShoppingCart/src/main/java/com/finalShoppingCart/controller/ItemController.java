package com.finalShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalShoppingCart.Entities.Item;
import com.finalShoppingCart.services.ItemService;

import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping(value="/item")
@Api(value="item", description="items for sale")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Item> addItem(Item item){
		itemService.addItem(item);
		if(itemService.addItem(item)){
			return new ResponseEntity<> (HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(Item item){
		itemService.deleteItem(item);
		if (itemService.deleteItem(item)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(Item item){
		itemService.updateItem(item);
		if (itemService.updateItem(item)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="item/{itemId}",method=RequestMethod.GET)
	public ResponseEntity<Item> getItemById(@PathVariable int itemId){
		itemService.getItemById(itemId);
		if (itemService.getItemById(itemId)!=null){
			return new ResponseEntity<Item>(itemService.getItemById(itemId),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="item/{typeId}",method=RequestMethod.GET)
	public ResponseEntity<List<Item>> getItemByType(@PathVariable int typeId){
		if(itemService.getItemByType(typeId)!=null){
			return new ResponseEntity<List<Item>> (itemService.getItemByType(typeId),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public ResponseEntity<List<Item>> getAllItems(){
		if(!itemService.getAllItems().isEmpty()){
			return new ResponseEntity<List<Item>>(itemService.getAllItems(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
