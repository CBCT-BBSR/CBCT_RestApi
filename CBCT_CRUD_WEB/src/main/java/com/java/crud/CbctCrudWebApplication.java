package com.java.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class CbctCrudWebApplication {
	 @RequestMapping("/")
	    public String hello(){
	        return "Hello World";
	    }
	public static void main(String[] args) {
		SpringApplication.run(CbctCrudWebApplication.class, args);
	}
}
