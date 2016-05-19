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

import com.finalShoppingCart.Entities.Item;
import com.finalShoppingCart.Entities.Sale;
import com.finalShoppingCart.Entities.ShoppingCart;
import com.finalShoppingCart.Entities.User;
import com.finalShoppingCart.services.ItemService;
import com.finalShoppingCart.services.UserSerivce;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api(value="user",description="this is an user")
public class UserController {

	@Autowired
	UserSerivce userService;
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody String userName,@RequestBody String userPass){
		try{
			return new ResponseEntity<User> (userService.validateUser(userName, userPass),HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> registerUser(User user){
		userService.addUser(user);
		if (userService.addUser(user)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(User user){
		userService.deleteUser(user);
		if(userService.deleteUser(user)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(User user){
		userService.updateUser(user);
		if(userService.updateUser(user)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public ResponseEntity<User> getUserByID(@PathVariable int userId){
		User user=userService.getUserById(userId);
		if (user!=null){
			return new ResponseEntity<User> (user,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUsers();
		
		if (!users.isEmpty()){
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/user/{userName}",method=RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@PathVariable String userName){
		User user=userService.getUserByName(userName);
		
		if (!user.equals(null)){
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/user/{userId}/cart/{itemId}",method=RequestMethod.PUT)
	public ResponseEntity<?> addItemTocart(@PathVariable int userId,@PathVariable int itemId){
		User user=userService.getUserById(userId);
		Item item=itemService.getItemById(itemId);
		
		if(!user.equals(null) && !item.equals(null)){
			user.getCart().addItemToCart(item);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/user/{userId}/cart/{itemId}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteItemFromcart(@PathVariable int userId,@PathVariable int itemId){
		User user=userService.getUserById(userId);
		Item item=itemService.getItemById(itemId);
		
		if(!user.equals(null) && !item.equals(null)){
			user.getCart().deleteItemFromCart(item);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/user/{userId}/cart",method=RequestMethod.GET)
	public ResponseEntity<ShoppingCart> getUserCart(@PathVariable int userId){
		User user=userService.getUserById(userId);
		
		if(!user.getCart().equals(null)){
			ShoppingCart cart=user.getCart();
			return new ResponseEntity<ShoppingCart>(cart,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/user/{userId}/cart",method=RequestMethod.DELETE)
	public ResponseEntity<?> clearCart(@PathVariable int userId){
		userService.getUserById(userId).getCart().clearItems();
		
		if(userService.getUserById(userId).getCart().equals(null)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/user/{userId}/cart/checkout",method=RequestMethod.POST)
	public ResponseEntity<Sale> doCheckOut(@PathVariable int userId){
		User user=userService.getUserById(userId);
		
		if(!user.equals(null)){
			user.getCart().checkOut();
			user.getCart().clearItems();
			user.getUserSales().add(user.getCart().checkOut());
			return new ResponseEntity<Sale>(user.getCart().checkOut(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}