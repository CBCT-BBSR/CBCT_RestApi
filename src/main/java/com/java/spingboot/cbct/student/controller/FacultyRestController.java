package com.java.spingboot.cbct.student.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.spingboot.cbct.student.model.Faculty;  
import com.java.spingboot.cbct.student.service.FacultyService;  
//mark class as Controller  
@RestController  
public class FacultyRestController   
{  
//autowire the BooksService class  
@Autowired  
FacultyService facultyService;  
//creating a get mapping that retrieves all the student detail from the database   
@GetMapping("/faculty")  
private List<Faculty> getAllFaculty()   
{  
return facultyService.getAllFaculty();  
}  
//creating a get mapping that retrieves the detail of a specific student  
@GetMapping("/faculty/{facultyid}")  
private Faculty getFaculty(@PathVariable("facultyid") int facultyid)   
{  
return facultyService.getFacultyById(facultyid);  
}  
//creating a delete mapping that deletes a specified student 
@DeleteMapping("/faculty/{facultyid}")  
private void deleteFaculty(@PathVariable("facultyid") int facultyid)   
{  
	facultyService.delete(facultyid);  
}  
//creating post mapping that post the student detail in the database  
@PostMapping("/faculty")  
private int saveFaculty(@RequestBody Faculty faculty)   
{  
	facultyService.saveOrUpdate(faculty);  
return faculty.getFacultyid();  
}  
//creating put mapping that updates the student detail   
@PutMapping("/faculty")  
private Faculty update(@RequestBody Faculty faculty)   
{  
	facultyService.saveOrUpdate(faculty);   
return faculty;  
}  
}  
