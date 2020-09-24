package com.java.springboot.cbct.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Studentlogin {
	@Id
	private long studentId;
	private String studentName;
	private String password;
	public Studentlogin(long studentId, String studentName, String password) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.password = password;
	}
	public Studentlogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Studentlogin [studentId=" + studentId + ", studentName=" + studentName + ", password=" + password + "]";
	}

	
	
	
	
}
