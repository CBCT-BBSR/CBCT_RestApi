package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.BasketRowMapper;
import com.java.crud.model.Basket;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class BasketRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Basket> getBasket(){
        return  jdbcTemplate.query("select basket_no,basket_id,basket_credit from basket",new BasketRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Basket findById(String basket_id){

        String sql = "SELECT * FROM basket WHERE BASKET_ID = ?";
        try{
            return  (Basket) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { basket_id }, new BasketRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveBasket(Basket basket){
        String query="insert into basket values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, basket.getBasket_no());
                ps.setString(2,basket.getBasket_id());
                ps.setInt(3, basket.getBasket_credit());

                return ps.execute();

            }
        });
    }
    
    public Integer updateBasket(Basket basket){
        String query="update basket set basket_no = ?,basket_credit = ? where basket_id = ?";
        Object[] params = {basket.getBasket_no(),basket.getBasket_credit() ,basket.getBasket_id()};
        int[] types = {Types.INTEGER,Types.INTEGER,Types.VARCHAR};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteBasketById(String basket_id){
        return jdbcTemplate.update("delete from basket where basket_id = ?",basket_id);
    }
}
