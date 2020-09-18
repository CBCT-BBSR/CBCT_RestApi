package com.java.crud.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class AcademicRowMapper implements RowMapper
{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Academic academic = new Academic();
        academic.setAcademic_no(rs.getInt("academic_no"));
        academic.setAcademic_year(rs.getString("academic_year"));
        academic.setBasket_1(rs.getInt("basket_1"));
        academic.setBasket_2(rs.getInt("basket_2"));
        academic.setBasket_3(rs.getInt("basket_3"));
        academic.setBasket_4(rs.getInt("basket_4"));
        academic.setBasket_5(rs.getInt("basket_5"));
        

        return academic;
    }

}
