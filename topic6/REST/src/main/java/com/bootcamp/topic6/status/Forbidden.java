package com.bootcamp.topic6.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.FORBIDDEN)
public class Forbidden extends RuntimeException{

	public String YouRForbidden(){
		return "You have no persmission";
	}
}
