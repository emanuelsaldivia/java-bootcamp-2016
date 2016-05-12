package com.bootcamp.topic6.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {

	public String ItemNotFound (int idItem){
		return "The item "+idItem+"could not be found";
	}
	
	public String UserNotFound (String userName){
		return "The user "+userName+"could not be found";
	}
	
	public String CartNotFound (){
		return "cart not found";
	}
	
	public String TotalNotFound(){
		return "total not found";
	}
	
}
