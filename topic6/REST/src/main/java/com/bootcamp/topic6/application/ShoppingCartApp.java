package com.bootcamp.topic6.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ShoppingCartApp {

	public static void main (String [] args){
		
		SpringApplication.run(ShoppingCartApp.class, args);
	}
}
