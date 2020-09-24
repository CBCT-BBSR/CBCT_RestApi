package com.java.springboot.cbct.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Facultylogin {

	@Id
	private long facultyId;
	private String facultyName;
	private String password;
	
	public Facultylogin(long facultyId, String facultyName, String password) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.password = password;
	}
	
	public Facultylogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Facultylogin [facultyId=" + facultyId + ", facultyName=" + facultyName + ", password=" + password + "]";
	}
	
	
}
