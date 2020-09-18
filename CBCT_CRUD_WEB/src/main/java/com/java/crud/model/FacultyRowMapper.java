package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class FacultyRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setFacultyid(rs.getInt("facultyid"));
        faculty.setFacultyname(rs.getString("facultyname"));
        faculty.setPassword(rs.getString("password"));
        faculty.setEmail(rs.getString("email"));
        faculty.setDesignation(rs.getString("designation"));
        

        return faculty;
    }

}
