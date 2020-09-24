package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StudentRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudent_no(rs.getInt("student_no"));
        student.setStudent_id(rs.getInt("student_id"));
        student.setStudent_name(rs.getString("student_name"));
        student.setPassword(rs.getString("password"));
        student.setAcademic_year(rs.getString("academic_year"));
        student.setBatch_id(rs.getString("batch_id"));
        student.setEmail(rs.getString("email"));
        student.setSchool(rs.getString("school"));
        student.setBranch(rs.getString("branch"));
        student.setDepartment(rs.getString("department"));

        return student;
    }

}
