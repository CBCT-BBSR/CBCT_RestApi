package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.BatchRowMapper;
import com.java.crud.model.Batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BatchRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Batch> getBatch(){
        return  jdbcTemplate.query("select batch_no,batch_id from batch",new BatchRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Batch findById(String batch_id){

        String sql = "SELECT * FROM batch WHERE BATCH_ID = ?";
        try{
            return  (Batch) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { batch_id }, new BatchRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveBatch(Batch batch){
        String query="insert into batch values(?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, batch.getBatch_no());
                ps.setString(2,batch.getBatch_id());

                return ps.execute();

            }
        });
    }

    public Integer deleteBatchById(String batch_id){
        return jdbcTemplate.update("delete from batch where batch_id = ?",batch_id);
    }
}
