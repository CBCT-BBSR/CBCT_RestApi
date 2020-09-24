package com.java.springboot.cbct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.cbct.entites.Facultylogin;
import com.java.springboot.cbct.services.FacultyLoginService;

@RestController
public class FacultyLoginController {
	@Autowired
	private FacultyLoginService facultyLoginService;

	
	//Get the Faculty details
	@GetMapping("/facultylogin")
	public List<Facultylogin> getDetails()
	{
		return this.facultyLoginService.getDetails();
	}
	@GetMapping("/facultylogin/{facultyId}/{password}")
	public Facultylogin getFaculty(@PathVariable String facultyId,@PathVariable String password)
	{
		return this.facultyLoginService.getFaculty(Long.parseLong(facultyId),password);
	}

	@PostMapping("/facultylogin")
	public Facultylogin addFaculty(@RequestBody Facultylogin facultylogin)
	{
		
		return this.facultyLoginService.addFaculty(facultylogin);
	}
}

