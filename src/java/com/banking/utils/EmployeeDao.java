package com.banking.utils;

import com.banking.model.Employee;
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
                            e.setId(rs.getInt("employee_id"));
                            e.setFirstName(rs.getString("employee_firstname"));
                            e.setMiddleName(rs.getString("employee_middlename"));
                            e.setLastName(rs.getString("employee_lastname"));
                            e.setHomeContact(rs.getString("employee_homecontact"));
                            e.setMobileNumber(rs.getString("employee_mobilecontact"));
                            e.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            e.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            e.setAddressId(rs.getInt("employee_address"));
                            String post  = rs.getString("employee_post");
                            e.setPost(EmployeePost.valueOf(post));
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
                            e.setId(rs.getInt("employee_id"));
                            e.setFirstName(rs.getString("employee_firstname"));
                            e.setMiddleName(rs.getString("employee_middlename"));
                            e.setLastName(rs.getString("employee_lastname"));
                            e.setHomeContact(rs.getString("employee_homecontact"));
                            e.setMobileNumber(rs.getString("employee_mobilecontact"));
                            e.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            e.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            e.setAddressId(rs.getInt("employee_address"));
                            String post  = rs.getString("employee_post");
                            e.setPost(EmployeePost.valueOf(post));
                            String department = rs.getString("employee_department");
                            e.setDepartment(DepartmentEnum.valueOf(department));
                            String status = rs.getString("employee_isactive");
                            e.setStatus(Status.valueOf(status));
                            String type = rs.getString("employee_isadmin");
                            e.setType(UserType.valueOf(type));
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
                            e.setFirstName(rs.getString("employee_firstname"));
                            e.setMiddleName(rs.getString("employee_middlename"));
                            e.setLastName(rs.getString("employee_lastname"));
                            e.setHomeContact(rs.getString("employee_homecontact"));
                            e.setMobileNumber(rs.getString("employee_mobilecontact"));
                            e.setDateOfBirth(rs.getString("employee_dateofbirth"));
                            e.setDateOfJoin(rs.getString("employee_dateofjoin"));
                            e.setAddressId(rs.getInt("employee_address"));
                            String post  = rs.getString("employee_post");
                            e.setPost(EmployeePost.valueOf(post));
                            list.add(e);
                        }
                        return list;
                    }
                });

    }

    public int saveEmployee(Employee e) {
        String query = "INSERT INTO employee_table(employee_firstname, employee_middlename, employee_lastname, "
                + "employee_homecontact, employee_mobilecontact, employee_dateofjoin, employee_dateofbirth, "
                + "employee_department, employee_post, employee_isactive, employee_isadmin) VALUES('" + e.getFirstName() + "','"
                + e.getMiddleName() + "','" + e.getLastName() + "','" + e.getHomeContact() + "','" + e.getMobileNumber()
                + "','" + e.getDateOfBirth() + "','" + e.getDateOfJoin() + "','" + e.getDepartment() + "', '"
                + e.getPost() + "', '" + e.getStatus() + "', '" + e.getType() + "')";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_firstname='" + e.getFirstName()
                + "', employee_middlename='" + e.getMiddleName() + "', employee_lastname='" + e.getLastName()
                + "', employee_homecontact='" + e.getHomeContact() + "', employee_mobilecontact='" + e.getMobileNumber()
                + "', employee_dateofjoin='" + e.getDateOfJoin() + "', employee_department='" + e.getDepartment()
                + "', employee_post='" + e.getPost() + "', employee_isadmin='" + e.getType()
                + "', employee_isactive='" + e.getStatus()
                + "' where employee_id='" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_isactive='0' WHERE employee_id='" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }

    public int restoreEmployee(Employee e) {
        String query = "UPDATE employee_table SET employee_isactive='1' WHERE employee_id='" + e.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
