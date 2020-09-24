package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class SubjectRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject();
        subject.setSubject_no(rs.getInt("subject_no"));
        subject.setSubject_name(rs.getString("subject_name"));
        subject.setSubject_code(rs.getString("subject_code"));
        subject.setSubject_credit(rs.getInt("subject_credit"));
        subject.setSubject_type(rs.getString("subject_type"));
        subject.setBasket_id(rs.getString("basket_id"));
         return subject;
    }

}
