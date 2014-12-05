package com.rkshakyaprojects.banking.model;

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
                            c.setId(rs.getInt("customer_id"));
                            c.setFirstName(rs.getString("customer_firstname"));
                            c.setMiddleName(rs.getString("customer_middlename"));
                            c.setLastName(rs.getString("customer_lastname"));
                            c.setPhone(rs.getString("customer_homecontact"));
                            c.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            c.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            c.setAddress(rs.getInt("customer_addressid"));
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
                            c.setId(rs.getInt("customer_id"));
                            c.setFirstName(rs.getString("customer_firstname"));
                            c.setMiddleName(rs.getString("customer_middlename"));
                            c.setLastName(rs.getString("customer_lastname"));
                            c.setPhone(rs.getString("customer_homecontact"));
                            c.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            c.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            c.setAddress(rs.getInt("customer_addressid"));
                            c.setIsActive(rs.getInt("customer_isactive"));
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
                            c.setId(rs.getInt("customer_id"));
                            c.setFirstName(rs.getString("customer_firstname"));
                            c.setMiddleName(rs.getString("customer_middlename"));
                            c.setLastName(rs.getString("customer_lastname"));
                            c.setPhone(rs.getString("customer_homecontact"));
                            c.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            c.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            c.setAddress(rs.getInt("customer_addressid"));
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
                + "customer_phone, customer_dateofbirth, customer_dateofjoin, customer_address, "
                + "customer_isactive) VALUES('" + c.getFirstName() + "', '" + c.getMiddleName() + "', '" + c.getLastName() + "', '"
                + c.getPhone() + "', '" + "', '" + c.getDateOfBirth() + "', '" + c.getDateOfJoin()
                + "', '" + c.getAddress() + "', '" + c.getIsActive() + "')";

        /*
         query = "INSERT INTO account (balance, account_createdby, account_createddate, lastaccess_date, account_isactive) "
         + "VALUES('" + c.getCity() + "', '" + c.getState() + "', '" + c.getZipcode() + "', '" + streetid + "')";

         */
        return jdbcTemplate.update(query);
    }

    public int updateCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_firstname='" + c.getFirstName() + "', customer_middlename='"
                + c.getMiddleName() + "', customer_lastname='" + c.getLastName() + "', customer_homecontact='"
                + c.getPhone()+ "', customer_mobilecontact='" + "', customer_dateofbirth='"
                + c.getDateOfBirth() + "', customer_dateofjoin='" + c.getDateOfJoin() + "', customer_isactive='"
                + c.getIsActive() + "' WHERE customer_id='" + c.getId() + "'";

        return jdbcTemplate.update(query);
    }

    public int deleteCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_isactive='0' WHERE customer_id='" + c.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int restoreCustomer(Customer c) {
        String query = "UPDATE customer_table SET customer_isactive='1' WHERE customer_id='" + c.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
