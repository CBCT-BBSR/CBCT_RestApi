package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.AcademicRowMapper;
import com.java.crud.model.Academic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class AcademicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Academic> getAcademic(){
        return  jdbcTemplate.query("select academic_no,academic_year,basket_1,basket_2,basket_3,basket_4,basket_5 from academic_year",new AcademicRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Academic findById(String academic_year){

        String sql = "SELECT * FROM academic_year WHERE ACADEMIC_YEAR = ?";
        try{
            return  (Academic) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { academic_year }, new AcademicRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveAcademic(Academic academic){
        String query="insert into academic_year values(?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,academic.getAcademic_no());
                ps.setString(2,academic.getAcademic_year());
                ps.setInt(3,academic.getBasket_1());
                ps.setInt(4,academic.getBasket_2());
                ps.setInt(5,academic.getBasket_3());
                ps.setInt(6,academic.getBasket_4());
                ps.setInt(7,academic.getBasket_5());

                return ps.execute();

            }
        });
    }

    public Integer updateAcademic(Academic academic){
        String query="update academic_year set academic_no = ? , basket_1 = ? , basket_2 = ? , basket_3 = ? , basket_4 = ? ,basket_5 = ? where academic_year = ?";
        Object[] params = {academic.getAcademic_no() ,academic.getBasket_1(),academic.getBasket_2(),academic.getBasket_3(),academic.getBasket_4(),academic.getBasket_5(),academic.getAcademic_year()};
        int[] types = {Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.VARCHAR};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteAcademicById(String academic_year){
        return jdbcTemplate.update("delete from academic_year where academic_year = ?",academic_year);
    }
}
