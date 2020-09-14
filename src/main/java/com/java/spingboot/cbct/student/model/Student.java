package com.java.spingboot.cbct.student.model;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table  
public class Student  
{  
//Defining book id as primary key  
@Id  
@Column  
private int studentid;  
@Column  
private String password;  
@Column  
private String studentname;  
@Column  
private String school;  
@Column  
private int academic_year; 
@Column  
private String department;  
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
@Column  
private String branch; 

public int getStudentid()   
{  
return studentid;  
}  
public void setStudentid(int studentid)   
{  
this.studentid = studentid;  
}  
public String getStudentname()  
{  
return studentname;  
}  
public void setStudentname(String studentname)   
{  
this.studentname = studentname;  
}  
public String getSchool()   
{  
return school;  
}  
public void setSchool(String school)   
{  
this.school = school;  
}  
public int getAcademic_year()   
{  
return academic_year;  
}  
public void setAcademic_year(int academic_year)   
{  
this.academic_year = academic_year;  
}  
}  
