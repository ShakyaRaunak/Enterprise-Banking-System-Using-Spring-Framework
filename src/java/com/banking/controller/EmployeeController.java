/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banking.controller;

import com.banking.model.Employee;
import com.banking.utils.DepartmentEnum;
import com.banking.utils.EmployeePost;
import com.banking.utils.Status;
import com.banking.utils.UserType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author raunakshakya
 */
public class EmployeeController {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> list() {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_isactive='1' ORDER BY employee_firstname ASC",
                new ResultSetExtractor<List<Employee>>() {
                    @Override
                    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Employee> list = new ArrayList<>();
                        while (rs.next()) {
                            Employee employee = new Employee();
                            employee.setId(rs.getInt("employee_id"));
                            employee.setFirstName(rs.getString("employee_firstname"));
                            employee.setMiddleName(rs.getString("employee_middlename"));
                            employee.setLastName(rs.getString("employee_lastname"));
                            employee.setHomeContact(rs.getString("employee_homecontact"));
                            employee.setMobileNumber(rs.getString("employee_mobilecontact"));
                            employee.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            employee.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            employee.setAddressId(rs.getInt("employee_address"));
                            String post = rs.getString("employee_post");
                            employee.setPost(EmployeePost.valueOf(post));
                            list.add(employee);
                        }
                        return list;
                    }
                });
    }

    public Employee findById(int empid) {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_id='" + empid + "'",
                new ResultSetExtractor<Employee>() {
                    @Override
                    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Employee employee = new Employee();
                        while (rs.next()) {
                            employee.setId(rs.getInt("employee_id"));
                            employee.setFirstName(rs.getString("employee_firstname"));
                            employee.setMiddleName(rs.getString("employee_middlename"));
                            employee.setLastName(rs.getString("employee_lastname"));
                            employee.setHomeContact(rs.getString("employee_homecontact"));
                            employee.setMobileNumber(rs.getString("employee_mobilecontact"));
                            employee.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            employee.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            employee.setAddressId(rs.getInt("employee_address"));
                            String post = rs.getString("employee_post");
                            employee.setPost(EmployeePost.valueOf(post));
                            String department = rs.getString("employee_department");
                            employee.setDepartment(DepartmentEnum.valueOf(department));
                            String status = rs.getString("employee_isactive");
                            employee.setStatus(Status.valueOf(status));
                            String type = rs.getString("employee_isadmin");
                            employee.setType(UserType.valueOf(type));
                        }
                        return employee;
                    }
                });
    }

    public List<Employee> listDeletedEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee_table WHERE employee_isactive='0' ORDER BY employee_firstname ASC",
                new ResultSetExtractor<List<Employee>>() {
                    @Override
                    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Employee> list = new ArrayList<>();
                        while (rs.next()) {
                            Employee employee = new Employee();
                            employee.setFirstName(rs.getString("employee_firstname"));
                            employee.setMiddleName(rs.getString("employee_middlename"));
                            employee.setLastName(rs.getString("employee_lastname"));
                            employee.setHomeContact(rs.getString("employee_homecontact"));
                            employee.setMobileNumber(rs.getString("employee_mobilecontact"));
                            employee.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            employee.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            employee.setAddressId(rs.getInt("employee_address"));
                            String post = rs.getString("employee_post");
                            employee.setPost(EmployeePost.valueOf(post));
                            list.add(employee);
                        }
                        return list;
                    }
                });
    }

    public int save(Employee employee) {
        String query = "INSERT INTO employee_table("
                + "employee_firstname, "
                + "employee_middlename, "
                + "employee_lastname, "
                + "employee_homecontact, "
                + "employee_mobilecontact, "
                + "employee_dateofjoin, "
                + "employee_dateofbirth, "
                + "employee_department, "
                + "employee_post, "
                + "employee_isactive, "
                + "employee_isadmin) "
                + "VALUES('"
                + employee.getFirstName() + "','"
                + employee.getMiddleName() + "','"
                + employee.getLastName() + "','"
                + employee.getHomeContact() + "','"
                + employee.getMobileNumber() + "','"
                + employee.getDateOfBirth() + "','"
                + employee.getDateOfJoin() + "','"
                + employee.getDepartment() + "', '"
                + employee.getPost() + "', '"
                + employee.getStatus() + "', '"
                + employee.getType() + "')";
        return jdbcTemplate.update(query);
    }

    public int update(Employee employee) {
        String query = "UPDATE employee_table SET "
                + "employee_firstname='" + employee.getFirstName() + "', "
                + "employee_middlename='" + employee.getMiddleName() + "', "
                + "employee_lastname='" + employee.getLastName() + "', "
                + "employee_homecontact='" + employee.getHomeContact() + "', "
                + "employee_mobilecontact='" + employee.getMobileNumber() + "', "
                + "employee_dateofjoin='" + employee.getDateOfJoin() + "', "
                + "employee_department='" + employee.getDepartment() + "', "
                + "employee_post='" + employee.getPost() + "', "
                + "employee_isadmin='" + employee.getType() + "', "
                + "employee_isactive='" + employee.getStatus() + "' "
                + "where "
                + "employee_id='" + employee.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int delete(Employee employee) {
        String query = "UPDATE employee_table SET "
                + "employee_isactive='0' "
                + "WHERE "
                + "employee_id='" + employee.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int restore(Employee employee) {
        String query = "UPDATE employee_table SET "
                + "employee_isactive='1' "
                + "WHERE "
                + "employee_id='" + employee.getId() + "'";
        return jdbcTemplate.update(query);
    }

}
