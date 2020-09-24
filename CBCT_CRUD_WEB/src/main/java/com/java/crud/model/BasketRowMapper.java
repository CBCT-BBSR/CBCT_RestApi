package com.java.crud.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class BasketRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Basket basket = new Basket();
        basket.setBasket_no(rs.getInt("basket_no"));
        basket.setBasket_id(rs.getString("basket_id"));
        basket.setBasket_credit(rs.getInt("basket_credit"));
         return basket;
    }

}
