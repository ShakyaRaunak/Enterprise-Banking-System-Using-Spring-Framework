/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking.controller;

import com.banking.model.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author raunakshakya
 */
public class AddressController {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Address getCustomerAddressID() {
        return jdbcTemplate.query("SELECT address_id FROM customer_address ORDER BY address_id DESC LIMIT 1",
                new ResultSetExtractor<Address>() {

                    @Override
                    public Address extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Address address = new Address();
                        if (rs.next()) {
                            address.setId(rs.getInt(1));
                        }
                        return address;
                    }
                });
    }

    public Address getSpecificAddress(int addressid) {
        return jdbcTemplate.query("SELECT * FROM customer_address WHERE address_id='" + addressid + "'",
                new ResultSetExtractor<Address>() {

                    @Override
                    public Address extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Address address = new Address();
                        if (rs.next()) {
                            address.setCity(rs.getString("city"));
                            address.setState(rs.getString("state"));
                            address.setZipCode(rs.getString("zip_code"));
                        }
                        return address;
                    }
                });
    }

    public int saveCustomerAddress(Address address) {
        String query = "INSERT INTO customer_address (city, state, zip_code) VALUES('"
                + address.getCity() + "', '" + address.getState() + "', '" + address.getZipCode() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateCustomerAddress(Address address) {
        String query = "UPDATE customer_address SET city='" + address.getCity() + "', state='" + address.getState() + "', zip_code='"
                + address.getZipCode() + "' WHERE address_id='" + address.getId() + "'";
        return jdbcTemplate.update(query);
    }

}
