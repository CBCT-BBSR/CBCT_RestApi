package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class BatchRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Batch batch = new Batch();
        batch.setBatch_no(rs.getInt("batch_no"));
        batch.setBatch_id(rs.getString("batch_id"));
         return batch;
    }

}
