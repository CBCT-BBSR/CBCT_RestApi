package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.FacultyRowMapper;
import com.java.crud.model.Faculty;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class FacultyRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Faculty> getFaculty(){
        return  jdbcTemplate.query("select facultyid,facultyname,password,email,designation from faculty",new FacultyRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Faculty findById(Integer facultyid){

        String sql = "SELECT * FROM faculty WHERE FACULTYID = ?";
        try{
            return  (Faculty) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { facultyid }, new FacultyRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveFaculty(Faculty faculty){
        String query="insert into faculty values(?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,faculty.getFacultyid());
                ps.setString(2,faculty.getFacultyname());
                ps.setString(3,faculty.getPassword());
                ps.setString(4,faculty.getEmail());
                ps.setString(5,faculty.getDesignation());

                return ps.execute();

            }
        });
    }

    public Integer updateFaculty(Faculty faculty){
        String query="update faculty set facultyname = ? , password = ? , email = ? , designation = ? where facultyid = ?";
        Object[] params = {faculty.getFacultyname() ,faculty.getPassword(),faculty.getEmail(),faculty.getDesignation(),faculty.getFacultyid()};
        int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteFacultyById(Integer facultyid){
        return jdbcTemplate.update("delete from faculty where facultyid = ?",facultyid);
    }
}
