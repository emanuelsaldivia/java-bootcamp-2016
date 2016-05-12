package com.bootcamp.topic6.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class Accepted {

	public String TransactionAccepted(){
		return "The transaction has been accepted";
	}
}
