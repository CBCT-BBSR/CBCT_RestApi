package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.SubjectRowMapper;
import com.java.crud.model.Subject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class SubjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Subject> getSubject(){
        return  jdbcTemplate.query("select subject_no,subject_name,subject_code,subject_credit,subject_type,basket_id from subject",new SubjectRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Subject findById(String subject_code){

        String sql = "SELECT * FROM subject WHERE SUBJECT_CODE = ?";
        try{
            return  (Subject) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { subject_code }, new SubjectRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveSubject(Subject subject){
        String query="insert into subject values(?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, subject.getSubject_no());
                ps.setString(2,subject.getSubject_name());
                ps.setString(3,subject.getSubject_code());
                ps.setInt(4,subject.getSubject_credit());
                ps.setString(5,subject.getSubject_type());
                ps.setString(6,subject.getBasket_id());

                return ps.execute();

            }
        });
    }
    
    public Integer updateSubject(Subject subject){
        String query="update subject set subject_no = ?,subject_name = ? , subject_credit = ?, subject_type = ? , basket_id = ?  where subject_code = ?";
        Object[] params = {subject.getSubject_no(),subject.getSubject_name(),subject.getSubject_credit(),subject.getSubject_type(),subject.getBasket_id(),subject.getSubject_code()};
        int[] types = {Types.INTEGER,Types.VARCHAR, Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteSubjectById(String subject_code){
        return jdbcTemplate.update("delete from subject where subject_code = ?",subject_code);
    }
}
