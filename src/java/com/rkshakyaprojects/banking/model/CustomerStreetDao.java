/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rkshakyaprojects.banking.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Raunak Shakya
 */
public class CustomerStreetDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerStreet getSpecificCustomerStreet(int streetid) {
        return jdbcTemplate.query("SELECT * FROM customer_street WHERE street_id='" + streetid + "'",
                new ResultSetExtractor<CustomerStreet>() {

                    @Override
                    public CustomerStreet extractData(ResultSet rs) throws SQLException, DataAccessException {

                        CustomerStreet cs = new CustomerStreet();
                        while (rs.next()) {
                            cs.setStreet(rs.getString("street_name"));
                            cs.setStreetnumber(rs.getString("street_number"));
                            cs.setApartmentnumber(rs.getString("apartment_number"));
                        }
                        return cs;
                    }
                });
    }

    public CustomerStreet getCustomerStreetID() {
        return jdbcTemplate.query("SELECT street_id FROM customer_street ORDER BY street_id DESC",
                new ResultSetExtractor<CustomerStreet>() {

                    @Override
                    public CustomerStreet extractData(ResultSet rs) throws SQLException, DataAccessException {
                        CustomerStreet cs = new CustomerStreet();
                        if (rs.next()) {
                            cs.setStreetid(rs.getInt("street_id"));
                        }
                        return cs;
                    }
                });
    }

    public int saveCustomerStreet(CustomerStreet cs) {
        String query = "INSERT INTO customer_street (street_name, apartment_number, street_number) VALUES('"
                + cs.getStreet() + "', '" + cs.getApartmentnumber() + "', '" + cs.getStreetnumber() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateCustomerStreet(CustomerStreet cs) {
        String query = "UPDATE customer_street SET street_name='"+cs.getStreet()+"',  street_number='"+cs.getStreetnumber() 
                +"', apartment_number='"+cs.getApartmentnumber()+"' WHERE street_id='"+cs.getStreetid()+"'";
        return jdbcTemplate.update(query);
    }

}
