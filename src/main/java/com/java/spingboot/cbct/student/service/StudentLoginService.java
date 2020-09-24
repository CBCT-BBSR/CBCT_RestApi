package com.java.springboot.cbct.services;

import java.util.List;


import com.java.springboot.cbct.entites.Studentlogin;

public interface StudentLoginService {
	public List<Studentlogin> getDetails();

	public Studentlogin getStudent(long studentId,String password);
	
	public Studentlogin addStudent(Studentlogin studentlogin);


}
