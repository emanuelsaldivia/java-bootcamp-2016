package com.bootcamp.topic6.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.bootcamp.topic6.classes.Item;
import com.bootcamp.topic6.classes.Sale;
import com.bootcamp.topic6.classes.User;
import com.bootcamp.topic6.imp.ItemImp;
import com.bootcamp.topic6.imp.ShoppingCartImp;
import com.bootcamp.topic6.imp.UserImp;
import com.bootcamp.topic6.services.ItemService;
import com.bootcamp.topic6.services.ShoppingCartService;
import com.bootcamp.topic6.services.UserService;
import com.bootcamp.topic6.status.Accepted;
import com.bootcamp.topic6.status.Forbidden;
import com.bootcamp.topic6.status.NotFound;
import com.bootcamp.topic6.status.Ok;

@RestController
@RequestMapping("/{userId}/shoppingcart")
public class UserController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	public UserController(){
		shoppingCartService= new ShoppingCartImp();
		userService = new UserImp();
		itemService= new ItemImp();
	}
	
	@RequestMapping(value="/{userId}/shoppingcart/{itemId}",method = RequestMethod.PUT)
	public void addItem (@PathVariable int userId,@PathVariable int itemId){
		
		User user=userService.getUser(userId);
		Item item=itemService.getItem(itemId);
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			userService.addItemToCart(item);
			if (shoppingCartService.addItem(item)){
				Ok ok;
				ok= new Ok();
				ok.TransactionIsOk();
			}
			else{
				NotFound notFound;
				notFound=new NotFound();
			
				for (int i=0;i>shoppingCartService.showCart().size();i++){
					if (shoppingCartService.getItem(i)==item){
						notFound.ItemNotFound(shoppingCartService.getItem(i).getItemId());
					}
				}	
			}
		}
	}
	
	@RequestMapping(value="/{userId}/shoppingcart/{itemId}",method=RequestMethod.DELETE)
	public void deleteItem(@PathVariable int userId,@PathVariable int itemId){
		
		User user=userService.getUser(userId);
		Item item=itemService.getItem(itemId);
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			userService.deleteCartItem(item);
			if (shoppingCartService.deleteItem(item)){
				Ok ok;
				ok= new Ok();
				ok.TransactionIsOk();
			}
			else
			{
				NotFound notFound;
				notFound=new NotFound();
			
				for (int i=0;i>shoppingCartService.showCart().size();i++){
					if (shoppingCartService.getItem(i)==item){
						notFound.ItemNotFound(shoppingCartService.getItem(i).getItemId());
					}
				}
			}
		}
	}
	
	@RequestMapping (value="/{userId}/shoppingcart/{itemId}",method=RequestMethod.GET)
	public Item getItem (@PathVariable int userId,@PathVariable int itemId){
		
		User user=userService.getUser(userId);
		Item item=itemService.getItem(itemId);
		
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			userService.selectItem(itemId);
		
			if (userService.selectItem(itemId)!=null){
				Accepted accepted;
				accepted = new Accepted();
				
				accepted.TransactionAccepted();
			}
			else{
				NotFound notFound;
				notFound=new NotFound();
			
				notFound.ItemNotFound(itemId);
			}
		}
		return userService.selectItem(itemId);
	}
	
	@RequestMapping (value="/{userId}/shoppingcart/checkout",method= RequestMethod.POST)
	public void checkOut (@PathVariable int userId){
		
		User user=userService.getUser(userId);
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			if(userService.showCart()!=null){
				Accepted accepted;
				accepted = new Accepted();
				Ok ok;
				ok = new Ok();
			
				accepted.TransactionAccepted();
				ok.TransactionIsOk();
			}
			else {
				NotFound notFound;
				notFound=new NotFound();
			
				notFound.CartNotFound();
			}
		}
		//return new Sale (user.checkOut());
	}
	
	@RequestMapping (value="/{userId}/shoppingcart/yourcart",method= RequestMethod.POST)
	public LinkedList<Item> showCart(@PathVariable int userId){
		
		User user=userService.getUser(userId);
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			if (userService.showCart()!=null){
				Accepted accepted;
				accepted = new Accepted();
				Ok ok;
				ok = new Ok();
			
				accepted.TransactionAccepted();
				ok.TransactionIsOk();
			}
			else {
				NotFound notFound;
				notFound=new NotFound();
			
				notFound.CartNotFound();
			}
		}
		return userService.showCart();
	}
	
	@RequestMapping (value="/{userId}/shoppingcart/yourtotal", method=RequestMethod.POST)
	public double getTotal (@PathVariable int userId){
		
		User user=userService.getUser(userId);
		if (!this.validateUser(user)){
			Forbidden forbidden;
			forbidden = new Forbidden();
			
			forbidden.YouRForbidden();
		}
		else{
			if (userService.showTotal()!=0){
				Accepted accepted;
				accepted = new Accepted();
				Ok ok;
				ok = new Ok();
			
				accepted.TransactionAccepted();
				ok.TransactionIsOk();
			}
		else {
			NotFound notFound;
			notFound=new NotFound();
			
			notFound.TotalNotFound();
			}
		}
			return userService.showTotal();
	}
	
	@RequestMapping (value="/{userId}", method=RequestMethod.GET)
	public String getUserName(@PathVariable int userId){
		
		User user=userService.getUser(userId);
		
		if(user.getUserName()!=null){
			Accepted accepted;
			accepted = new Accepted();
			Ok ok;
			ok = new Ok();
		
			accepted.TransactionAccepted();
			ok.TransactionIsOk();
		}
		else{
			NotFound notFound;
			notFound=new NotFound();
			
			notFound.UserNotFound(user.getUserName());
		}
		return user.getUserName();
	}
	
	private boolean validateUser(User user){
		
		if(userService.getUser(user.getUserId()).equals(user)){
			return true;
		}
		else{
			return false;
		}
	}
}
