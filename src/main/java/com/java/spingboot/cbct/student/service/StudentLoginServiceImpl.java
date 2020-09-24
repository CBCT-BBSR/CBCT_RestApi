package com.java.springboot.cbct.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.cbct.dao.StudentLoginDao;
import com.java.springboot.cbct.entites.Studentlogin;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
	
	@Autowired
	private StudentLoginDao studentLoginDao;
	//List <Studentlogin> list;
	
	public StudentLoginServiceImpl() {
		
//		list = new ArrayList<>();
//		list.add(new Studentlogin(024,"Suraj Kumar Gupta","1288"));
//		list.add(new Studentlogin(032,"Soumya Prakash Achraya","1234"));
//		list.add(new Studentlogin(166,"Lovely Sahoo","123"));

		
	}

	@Override
	public List<Studentlogin> getDetails() {
		// TODO Auto-generated method stub
		//return list;
		return studentLoginDao.findAll();
	}

	@Override
	public Studentlogin getStudent(long studentId, String password) {
//		// TODO Auto-generated method stub
//		Studentlogin sl = null;
//		
//		for(Studentlogin studentlogin:list)
//		{
//			if(studentlogin.getStudentId()==studentId && studentlogin.getPassword().equals(password))
//			{
//				sl = studentlogin;
//				break;
//			}
//		}
		//return sl;
		return studentLoginDao.findByStudentIdAndPassword(studentId,password);
	}

	@Override
	public Studentlogin addStudent(Studentlogin studentlogin) {

	//	list.add(studentlogin);
		
		studentLoginDao.save(studentlogin);
		
		return studentlogin;
	}

}
