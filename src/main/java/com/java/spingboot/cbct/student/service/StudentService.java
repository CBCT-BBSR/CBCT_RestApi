package com.java.spingboot.cbct.student.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.java.spingboot.cbct.student.model.Student;  
import com.java.spingboot.cbct.student.repository.StudentRepository;  
//defining the business logic  
@Service  
public class StudentService   
{  
@Autowired  
StudentRepository studentRepository;  
//getting all books record by using the method findaAll() of CrudRepository  
public List<Student> getAllStudent()   
{  
List<Student> student = new ArrayList<Student>();  
studentRepository.findAll().forEach(student1 -> student.add(student1));  
return student;  
}  
//getting a specific record by using the method findById() of CrudRepository  
public Student getStudentById(int id)   
{  
return studentRepository.findById(id).get();  
}  
//saving a specific record by using the method save() of CrudRepository  
public void saveOrUpdate(Student student)   
{  
	studentRepository.save(student);  
}  
//deleting a specific record by using the method deleteById() of CrudRepository  
public void delete(int id)   
{  
	studentRepository.deleteById(id);  
}  
//updating a record  
public void update(Student student, int studentid)   
{  
	studentRepository.save(student);  
}  
}  
