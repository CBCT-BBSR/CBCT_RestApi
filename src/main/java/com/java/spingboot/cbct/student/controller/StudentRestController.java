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

import com.java.spingboot.cbct.student.model.Student;  
import com.java.spingboot.cbct.student.service.StudentService;  
//mark class as Controller  
@RestController  
public class StudentRestController   
{  
//autowire the BooksService class  
@Autowired  
StudentService studentService;  
//creating a get mapping that retrieves all the student detail from the database   
@GetMapping("/student")  
private List<Student> getAllStudent()   
{  
return studentService.getAllStudent();  
}  
//creating a get mapping that retrieves the detail of a specific student  
@GetMapping("/student/{studentid}")  
private Student getStudent(@PathVariable("studentid") int studentid)   
{  
return studentService.getStudentById(studentid);  
}  
//creating a delete mapping that deletes a specified student 
@DeleteMapping("/student/{studentid}")  
private void deleteStudent(@PathVariable("studentid") int studentid)   
{  
	studentService.delete(studentid);  
}  
//creating post mapping that post the student detail in the database  
@PostMapping("/student")  
private int saveStudent(@RequestBody Student student)   
{  
	studentService.saveOrUpdate(student);  
return student.getStudentid();  
}  
//creating put mapping that updates the student detail   
@PutMapping("/student")  
private Student update(@RequestBody Student student)   
{  
	studentService.saveOrUpdate(student);   
return student;  
}  
}  

