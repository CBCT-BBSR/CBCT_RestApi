package com.java.springboot.cbct.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springboot.cbct.entites.Facultylogin;


public interface FacultyLoginDao extends JpaRepository<Facultylogin, Long>{
	
    public Facultylogin findByFacultyIdAndPassword(long facultyId, String password);


}
