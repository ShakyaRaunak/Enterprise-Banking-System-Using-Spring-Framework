/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_isactive='1' ORDER BY employee_firstname ASC",
                new ResultSetExtractor<List<Employee>>() {

                    @Override
                    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        List<Employee> list = new ArrayList<>();
                        while (rs.next()) {
                            Employee e = new Employee();
                            e.setEmpID(rs.getInt("employee_id"));
                            e.setFirstname(rs.getString("employee_firstname"));
                            e.setMiddlename(rs.getString("employee_middlename"));
                            e.setLastname(rs.getString("employee_lastname"));
                            e.setHomecontact(rs.getString("employee_homecontact"));
                            e.setMobilecontact(rs.getString("employee_mobilecontact"));
                            e.setDateofbirth(rs.getString("employee_dateofbirth"));
                            e.setDateofjoin(rs.getString("employee_dateofjoin"));
                            e.setAddress(rs.getString("employee_address"));
                            e.setPost(rs.getString("employee_post"));
                            list.add(e);
                        }
                        return list;
                    }
                });

    }

    public Employee getSpecificEmployee(int empid) {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_id='" + empid + "'",
                new ResultSetExtractor<Employee>() {

                    @Override
                    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Employee e = new Employee();
                        while (rs.next()) {
                            e.setEmpID(rs.getInt("employee_id"));
                            e.setFirstname(rs.getString("employee_firstname"));
                            e.setMiddlename(rs.getString("employee_middlename"));
                            e.setLastname(rs.getString("employee_lastname"));
                            e.setHomecontact(rs.getString("employee_homecontact"));
                            e.setMobilecontact(rs.getString("employee_mobilecontact"));
                            e.setDateofbirth(rs.getString("employee_dateofbirth"));
                            e.setDateofjoin(rs.getString("employee_dateofjoin"));
                            e.setAddress(rs.getString("employee_address"));
                            e.setDepartment(rs.getString("employee_department"));
                            e.setPost(rs.getString("employee_post"));
                            e.setIsactive(rs.getInt("employee_isactive"));
                            e.setIsadmin(rs.getInt("employee_isadmin"));
                        }
                        return e;
                    }
                });
    }

    public List<Employee> getDeletedEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_isactive='0' ORDER BY employee_firstname ASC",
                new ResultSetExtractor<List<Employee>>() {

                    @Override
                    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

                        List<Employee> list = new ArrayList<>();
                        while (rs.next()) {
                            Employee e = new Employee();
                            e.setEmpID(rs.getInt("employee_id"));
                            e.setFirstname(rs.getString("employee_firstname"));
                            e.setMiddlename(rs.getString("employee_middlename"));
                            e.setLastname(rs.getString("employee_lastname"));
                            e.setHomecontact(rs.getString("employee_homecontact"));
                            e.setMobilecontact(rs.getString("employee_mobilecontact"));
                            e.setDateofbirth(rs.getString("employee_dateofbirth"));
                            e.setDateofjoin(rs.getString("employee_dateofjoin"));
                            e.setAddress(rs.getString("employee_address"));
                            e.setPost(rs.getString("employee_post"));
                            list.add(e);
                        }
                        return list;
                    }
                });

    }

    public int saveEmployee(Employee e) {
        String query = "INSERT INTO employee_table(employee_firstname, employee_middlename, employee_lastname, "
                + "employee_homecontact, employee_mobilecontact, employee_dateofjoin, employee_dateofbirth, "
                + "employee_department, employee_post, employee_isactive, employee_isadmin) VALUES('" + e.getFirstname() + "','"
                + e.getMiddlename() + "','" + e.getLastname() + "','" + e.getHomecontact() + "','" + e.getMobilecontact()
                + "','" + e.getDateofbirth() + "','" + e.getDateofjoin() + "','" + e.getDepartment() + "', '"
                + e.getPost() + "', '" + e.getIsactive() + "', '" + e.getIsadmin() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_firstname='" + e.getFirstname()
                + "', employee_middlename='" + e.getMiddlename() + "', employee_lastname='" + e.getLastname()
                + "', employee_homecontact='" + e.getHomecontact() + "', employee_mobilecontact='" + e.getMobilecontact()
                + "', employee_dateofjoin='" + e.getDateofjoin() + "', employee_department='" + e.getDepartment()
                + "', employee_post='" + e.getPost() + "', employee_isadmin='" + e.getIsadmin()
                + "', employee_isactive='" + e.getIsactive()
                + "' where employee_id='" + e.getEmpID() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_isactive='0' WHERE employee_id='" + e.getEmpID() + "'";
        return jdbcTemplate.update(query);
    }

    public int restoreEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_isactive='1' WHERE employee_id='" + e.getEmpID() + "'";
        return jdbcTemplate.update(query);
    }
}
