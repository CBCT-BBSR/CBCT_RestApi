package com.java.spingboot.cbct.student.repository;
import org.springframework.data.repository.CrudRepository;  
import com.java.spingboot.cbct.student.model.Student;  
//repository that extends CrudRepository  
public interface StudentRepository extends CrudRepository<Student, Integer>  
{  
}  