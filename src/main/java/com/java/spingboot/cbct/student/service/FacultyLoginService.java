package com.java.springboot.cbct.services;

import java.util.List;

import com.java.springboot.cbct.entites.Facultylogin;


public interface FacultyLoginService {
	
	public List<Facultylogin> getDetails();

	public Facultylogin getFaculty(long facultyId,String password);
	
	public Facultylogin addFaculty(Facultylogin facultylogin);


}
