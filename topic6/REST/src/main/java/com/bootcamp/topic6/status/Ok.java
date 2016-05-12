package com.bootcamp.topic6.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class Ok {
	
	public String TransactionIsOk(){
		return "The transaction has been completed succesfuly";
	}
}
