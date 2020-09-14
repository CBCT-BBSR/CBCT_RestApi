package com.java.spingboot.cbct.student.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.java.spingboot.cbct.student.model.Faculty;
import com.java.spingboot.cbct.student.repository.FacultyRepository; 
//defining the business logic  
@Service  
public class FacultyService   
{  
@Autowired  FacultyRepository facultyRepository;  
//getting all books record by using the method findaAll() of CrudRepository  
public List<Faculty> getAllFaculty()   
{  
List<Faculty> faculty = new ArrayList<Faculty>();  
facultyRepository.findAll().forEach(faculty1 -> faculty.add(faculty1));  
return faculty;  
}  
//getting a specific record by using the method findById() of CrudRepository  
public Faculty getFacultyById(int id)   
{  
return facultyRepository.findById(id).get();  
}  
//saving a specific record by using the method save() of CrudRepository  
public void saveOrUpdate(Faculty faculty)   
{  
	facultyRepository.save(faculty);  
}  
//deleting a specific record by using the method deleteById() of CrudRepository  
public void delete(int id)   
{  
	facultyRepository.deleteById(id);  
}  
//updating a record  
public void update(Faculty faculty, int facultyid)   
{  
	facultyRepository.save(faculty);  
}

}  
