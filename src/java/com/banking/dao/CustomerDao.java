package com.banking.dao;

import com.banking.model.Customer;
import com.banking.utils.Status;
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
                        List<Customer> customers = new ArrayList<>();
                        while (rs.next()) {
                            Customer customer = new Customer();
                            customer.setId(rs.getInt("customer_id"));
                            customer.setFirstName(rs.getString("customer_firstname"));
                            customer.setMiddleName(rs.getString("customer_middlename"));
                            customer.setLastName(rs.getString("customer_lastname"));
                            customer.setPhone(rs.getString("customer_homecontact"));
                            customer.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            customer.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            customer.setAddressId(rs.getInt("customer_addressid"));
                            customers.add(customer);
                        }
                        return customers;
                    }
                });
    }

    public Customer getSpecificCustomer(int custid) {
        return jdbcTemplate.query("SELECT * FROM customer_table WHERE customer_id='" + custid + "'",
                new ResultSetExtractor<Customer>() {

                    @Override
                    public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Customer customer = new Customer();
                        while (rs.next()) {
                            customer.setId(rs.getInt("customer_id"));
                            customer.setFirstName(rs.getString("customer_firstname"));
                            customer.setMiddleName(rs.getString("customer_middlename"));
                            customer.setLastName(rs.getString("customer_lastname"));
                            customer.setPhone(rs.getString("customer_homecontact"));
                            customer.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            customer.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            customer.setAddressId(rs.getInt("customer_addressid"));
                            String status = rs.getString("customer_isactive");
                            customer.setStatus(Status.valueOf(status));
                        }
                        return customer;
                    }
                });
    }

    public List<Customer> getDeletedCustomers() {
        return jdbcTemplate.query("SELECT * FROM customer_table WHERE customer_isactive='0' ORDER BY customer_firstname ASC",
                new ResultSetExtractor<List<Customer>>() {

                    @Override
                    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Customer> customers = new ArrayList<>();
                        while (rs.next()) {
                            Customer customer = new Customer();
                            customer.setId(rs.getInt("customer_id"));
                            customer.setFirstName(rs.getString("customer_firstname"));
                            customer.setMiddleName(rs.getString("customer_middlename"));
                            customer.setLastName(rs.getString("customer_lastname"));
                            customer.setPhone(rs.getString("customer_homecontact"));
                            customer.setDateOfBirth(rs.getString("customer_dateofbirth"));
                            customer.setDateOfJoin(rs.getString("customer_dateofjoin"));
                            customer.setAddressId(rs.getInt("customer_addressid"));
                            customers.add(customer);
                        }
                        return customers;
                    }
                });
    }

    public int saveCustomer(Customer customer) {
        String query = "INSERT INTO customer_table (customer_firstname, customer_middlename, customer_lastname, "
                + "customer_phone, customer_dateofbirth, customer_dateofjoin, customer_address, "
                + "customer_isactive) VALUES('" + customer.getFirstName() + "', '" + customer.getMiddleName() + "', '" + customer.getLastName() + "', '"
                + customer.getPhone() + "', '" + "', '" + customer.getDateOfBirth() + "', '" + customer.getDateOfJoin()
                + "', '" + customer.getAddressId() + "', '" + customer.getStatus() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateCustomer(Customer customer) {
        String query = "UPDATE customer_table SET customer_firstname='" + customer.getFirstName() + "', customer_middlename='"
                + customer.getMiddleName() + "', customer_lastname='" + customer.getLastName() + "', customer_homecontact='"
                + customer.getPhone() + "', customer_mobilecontact='" + "', customer_dateofbirth='"
                + customer.getDateOfBirth() + "', customer_dateofjoin='" + customer.getDateOfJoin() + "', customer_isactive='"
                + customer.getStatus() + "' WHERE customer_id='" + customer.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteCustomer(Customer customer) {
        String query = "UPDATE customer_table SET customer_isactive='0' WHERE customer_id='" + customer.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int restoreCustomer(Customer customer) {
        String query = "UPDATE customer_table SET customer_isactive='1' WHERE customer_id='" + customer.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
