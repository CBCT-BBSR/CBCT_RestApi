package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.SemesterRowMapper;
import com.java.crud.model.Semester;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SemesterRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Semester> getSemester(){
        return  jdbcTemplate.query("select semester_no,semester_id from semester",new SemesterRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Semester findById(String semester_id){

        String sql = "SELECT * FROM semester WHERE SEMESTER_ID = ?";
        try{
            return  (Semester) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { semester_id }, new SemesterRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveSemester(Semester semester){
        String query="insert into semester values(?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, semester.getSemester_no());
                ps.setString(2,semester.getSemester_id());

                return ps.execute();

            }
        });
    }
    

    public Integer deleteSemesterById(String semester_id){
        return jdbcTemplate.update("delete from semester where semester_id = ?",semester_id);
    }
}
