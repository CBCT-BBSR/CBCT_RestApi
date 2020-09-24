package com.java.springboot.cbct.dao;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.java.springboot.cbct.entites.Studentlogin;

public interface StudentLoginDao extends JpaRepository<Studentlogin, Long>{

	/*
	 * @Query( value = 
	 * "SELECT * FROM Studentlogin sl where sl.studentId = :studentId AND sl.password = :password"
	 * , nativeQuery=true )
	 */
    public Studentlogin findByStudentIdAndPassword(long studentId, String password);
}
