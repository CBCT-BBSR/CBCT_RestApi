package com.java.springboot.cbct.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.cbct.dao.FacultyLoginDao;
import com.java.springboot.cbct.entites.Facultylogin;

@Service
public class FacultyLoginServiceImpl implements FacultyLoginService{
	
	
	@Autowired
	private FacultyLoginDao facultyLoginDao;
	
		public FacultyLoginServiceImpl() {
			
		}

	@Override
	public List<Facultylogin> getDetails() {
		// TODO Auto-generated method stub
		return facultyLoginDao.findAll();

	}

	@Override
	public Facultylogin getFaculty(long facultyId, String password) {
		return facultyLoginDao.findByFacultyIdAndPassword(facultyId, password);
	}

	@Override
	public Facultylogin addFaculty(Facultylogin facultylogin) {
		// TODO Auto-generated method stub
		facultyLoginDao.save(facultylogin);
		
		return facultylogin;
	}

}
