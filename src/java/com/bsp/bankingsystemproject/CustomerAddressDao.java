/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsp.bankingsystemproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Raunak Shakya
 */
public class CustomerAddressDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerAddress getCustomerAddressID() {
        return jdbcTemplate.query("SELECT address_id FROM customer_address ORDER BY address_id DESC LIMIT 1",
                new ResultSetExtractor<CustomerAddress>() {

                    @Override
                    public CustomerAddress extractData(ResultSet rs) throws SQLException, DataAccessException {
                        CustomerAddress ca = new CustomerAddress();
                        if (rs.next()) {
                            ca.setAddressid(rs.getInt(1));
                        }
                        return ca;
                    }
                });
    }

    public CustomerAddress getSpecificCustomerAddress(int addressid) {
        return jdbcTemplate.query("SELECT * FROM customer_address WHERE address_id='" + addressid + "'",
                new ResultSetExtractor<CustomerAddress>() {

                    @Override
                    public CustomerAddress extractData(ResultSet rs) throws SQLException, DataAccessException {
                        CustomerAddress ca = new CustomerAddress();
                        if (rs.next()) {
                            ca.setStreetid(rs.getInt("street_id"));
                            ca.setCity(rs.getString("city"));
                            ca.setState(rs.getString("state"));
                            ca.setZipcode(rs.getString("zip_code"));
                        }
                        return ca;
                    }
                });
    }

    public int saveCustomerAddress(CustomerAddress ca) {
        String query = "INSERT INTO customer_address (city, state, zip_code, street_id) VALUES('"
                + ca.getCity() + "', '" + ca.getState() + "', '" + ca.getZipcode() + "', '" + ca.getStreetid() + "')";

        return jdbcTemplate.update(query);
    }

    public int updateCustomerAddress(CustomerAddress ca) {
        String query = "UPDATE customer_address SET city='"+ca.getCity()+"', state='" +ca.getState()+"', zip_code='"
                +ca.getZipcode()+"' WHERE address_id='"+ca.getAddressid()+"'";
        return jdbcTemplate.update(query);
    }

}
