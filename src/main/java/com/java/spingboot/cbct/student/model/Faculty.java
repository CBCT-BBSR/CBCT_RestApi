package com.java.spingboot.cbct.student.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table  
public class Faculty  
{  
//Defining book id as primary key  
@Id  
@Column  
private int facultyid;  
@Column  
private String facultyname;  
@Column  
private String designation;  
@Column  
private String password; 
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getFacultyid()   
{  
return facultyid;  
}  
public void setFacultyid(int facultyid)   
{  
this.facultyid = facultyid;  
}  
public String getFacultyname()  
{  
return facultyname;  
}  
public void setFacultyname( String facultyname)   
{  
this.facultyname = facultyname;  
}  
public String getDesignation()   
{  
return designation;  
}  
public void setDesignation(String designation)   
{  
this.designation = designation;  
}  
}  
