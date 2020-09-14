package com.java.spingboot.cbct.student.repository;
import org.springframework.data.repository.CrudRepository;

import com.java.spingboot.cbct.student.model.Faculty;
public interface FacultyRepository extends CrudRepository<Faculty, Integer>   {

}
