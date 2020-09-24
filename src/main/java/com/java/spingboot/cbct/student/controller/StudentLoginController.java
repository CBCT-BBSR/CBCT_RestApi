/**
 * 
 */
package com.java.springboot.cbct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.cbct.entites.Studentlogin;
import com.java.springboot.cbct.services.StudentLoginService;

/**
 * @author Suraj
 *
 */
@RestController
public class StudentLoginController {
	@Autowired
	private StudentLoginService studentLoginService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to the spring Boot";
	}
	
	//Get the student details
	@GetMapping("/studentlogin")
	public List<Studentlogin> getDetails()
	{
		return this.studentLoginService.getDetails();
	}
	@GetMapping("/studentlogin/{studentId}/{password}")
	public Studentlogin getStudent(@PathVariable String studentId,@PathVariable String password)
	{
		return this.studentLoginService.getStudent(Long.parseLong(studentId),password);
	}

	@PostMapping("/studentlogin")
	public Studentlogin addStudent(@RequestBody Studentlogin studentlogin)
	{
		
		return this.studentLoginService.addStudent(studentlogin);
	}
}
