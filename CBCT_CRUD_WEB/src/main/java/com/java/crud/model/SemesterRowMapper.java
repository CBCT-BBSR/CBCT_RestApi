package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class SemesterRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Semester semester = new Semester();
        semester.setSemester_no(rs.getInt("semester_no"));
        semester.setSemester_id(rs.getString("semester_id"));
         return semester;
    }

}
