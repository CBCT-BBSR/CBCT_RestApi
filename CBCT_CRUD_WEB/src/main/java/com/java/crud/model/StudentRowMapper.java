package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StudentRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentno(rs.getInt("studentno"));
        student.setStudentid(rs.getInt("studentid"));
        student.setStudentname(rs.getString("studentname"));
        student.setPassword(rs.getString("password"));
        student.setAcademic_year(rs.getString("academic_year"));
        student.setEmailid(rs.getString("emailid"));
        student.setSchool(rs.getString("school"));
        student.setBranch(rs.getString("branch"));
        student.setDepartment(rs.getString("department"));

        return student;
    }

}
