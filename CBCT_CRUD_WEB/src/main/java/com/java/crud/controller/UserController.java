package com.java.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.crud.model.User;
import com.java.crud.services.UserService;
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	//creating post mapping that post the user detail in the database  
	@PostMapping("/user")  
	private User saveUser(@RequestBody User user)   
	{  
		User message = null;
        try {
            message = userService.saveOrUpdate(user);
        } catch (Exception e) {
         message = new User();
        }
    return message;
    }
	
	@GetMapping("/login/{email}/{password}/{role}")
	public User findByEmailAndPasswordAndRole(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable("role") String role) {
		 User message = null;
	        try {
	            message = userService.findByEmailAndPasswordAndRole(email, password, role);
	        } catch (Exception e) {
	         message = new User();
	        }
	    return message;
	    }

	@GetMapping("/forgotpassword/{email}/{password}")
	public Integer ForgotPassword(@PathVariable("email") String email,@PathVariable("password") String password) {
	Integer result = userService.ForgotPassword(email, password);
		return result;	
		
	}
	@GetMapping("/changepassword/{email}/{password}/{newpassword}")
	public Integer ChangePassword(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable("newpassword") String newpassword) {
		Integer result = userService.ChangePassword(email, password, newpassword);
		return result;
	}
}