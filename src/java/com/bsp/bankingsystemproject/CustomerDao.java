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
public class CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer_table WHERE customer_isactive='1' ORDER BY customer_firstname ASC",
                new ResultSetExtractor<List<Customer>>() {

                    @Override
                    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        List<Customer> list = new ArrayList<>();
                        while (rs.next()) {
                            Customer c = new Customer();
                            c.setCustID(rs.getInt("customer_id"));
                            c.setFirstname(rs.getString("customer_firstname"));
                            c.setMiddlename(rs.getString("customer_middlename"));
                            c.setLastname(rs.getString("customer_lastname"));
                            c.setHomecontact(rs.getString("customer_homecontact"));
                            c.setMobilecontact(rs.getString("customer_mobilecontact"));
                            c.setDateofbirth(rs.getString("customer_dateofbirth"));
                            c.setDateofjoin(rs.getString("customer_dateofjoin"));
                            c.setAddressid(rs.getInt("customer_addressid"));
                            list.add(c);
                        }
                        return list;
                    }
                });
    }

    public Customer getSpecificCustomer(int custid) {
        return jdbcTemplate.query("SELECT * FROM customer_table WHERE customer_id='" + custid + "'",
                new ResultSetExtractor<Customer>() {

                    @Override
                    public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Customer c = new Customer();
                        while (rs.next()) {
                            c.setCustID(rs.getInt("customer_id"));
                            c.setFirstname(rs.getString("customer_firstname"));
                            c.setMiddlename(rs.getString("customer_middlename"));
                            c.setLastname(rs.getString("customer_lastname"));
                            c.setHomecontact(rs.getString("customer_homecontact"));
                            c.setMobilecontact(rs.getString("customer_mobilecontact"));
                            c.setDateofbirth(rs.getString("customer_dateofbirth"));
                            c.setDateofjoin(rs.getString("customer_dateofjoin"));
                            c.setAddressid(rs.getInt("customer_addressid"));
                            c.setIsactive(rs.getInt("customer_isactive"));
                        }
                        return c;
                    }
                });
    }

    public List<Customer> getDeletedCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer_table WHERE customer_isactive='0' ORDER BY customer_firstname ASC",
                new ResultSetExtractor<List<Customer>>() {

                    @Override
                    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        List<Customer> list = new ArrayList<>();
                        while (rs.next()) {
                            Customer c = new Customer();
                            c.setCustID(rs.getInt("customer_id"));
                            c.setFirstname(rs.getString("customer_firstname"));
                            c.setMiddlename(rs.getString("customer_middlename"));
                            c.setLastname(rs.getString("customer_lastname"));
                            c.setHomecontact(rs.getString("customer_homecontact"));
                            c.setMobilecontact(rs.getString("customer_mobilecontact"));
                            c.setDateofbirth(rs.getString("customer_dateofbirth"));
                            c.setDateofjoin(rs.getString("customer_dateofjoin"));
                            c.setAddressid(rs.getInt("customer_addressid"));
                            list.add(c);
                        }
                        return list;
                    }
                });
    }

    public int saveCustomer(Customer c) {
        //, customer_accountid, customer_isactive, customer_loginname, customer_loginpass
        //"', '" + c.getAccountid() + "', '" + c.getIsactive() + "', '" + c.getLoginname()
        //+ "', '" + c.getLoginpass() + 
        String query = "INSERT INTO customer_table (customer_firstname, customer_middlename, customer_lastname, "
                + "customer_homecontact, customer_mobilecontact, customer_dateofbirth, customer_dateofjoin, customer_addressid, "
                + "customer_isactive) VALUES('" + c.getFirstname() + "', '" + c.getMiddlename() + "', '" + c.getLastname() + "', '"
                + c.getHomecontact() + "', '" + c.getMobilecontact() + "', '" + c.getDateofbirth() + "', '" + c.getDateofjoin()
                + "', '" + c.getAddressid() + "', '" + c.getIsactive() + "')";

        /*
         query = "INSERT INTO account (balance, account_createdby, account_createddate, lastaccess_date, account_isactive) "
         + "VALUES('" + c.getCity() + "', '" + c.getState() + "', '" + c.getZipcode() + "', '" + streetid + "')";

         */
        return jdbcTemplate.update(query);
    }

    public int updateCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_firstname='" + c.getFirstname() + "', customer_middlename='"
                + c.getMiddlename() + "', customer_lastname='" + c.getLastname() + "', customer_homecontact='"
                + c.getHomecontact() + "', customer_mobilecontact='" + c.getMobilecontact() + "', customer_dateofbirth='"
                + c.getDateofbirth() + "', customer_dateofjoin='" + c.getDateofjoin() + "', customer_isactive='"
                + c.getIsactive() + "' WHERE customer_id='" + c.getCustID() + "'";

        return jdbcTemplate.update(query);
    }

    public int deleteCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_isactive='0' WHERE customer_id='" + c.getCustID() + "'";
        return jdbcTemplate.update(query);
    }
    
    public int restoreCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_isactive='1' WHERE customer_id='" + c.getCustID() + "'";
        return jdbcTemplate.update(query);
    }
}
