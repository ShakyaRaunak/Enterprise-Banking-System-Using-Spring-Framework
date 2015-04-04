package com.banking.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raunak Shakya
 */
public class LoginBean {

    private Integer id;
    private String username;
    private String password;
    private Boolean isAdmin;
    private Boolean isEmployee;
    private Boolean isCustomer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public boolean authenticate() throws SQLException, ClassNotFoundException {
        DBConnectionUtils conn = new DBConnectionUtils();
        conn.connect();
        PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT * FROM employee_table");
        ResultSet rs = stmt.executeQuery();
        String receivedLoginname;
        String receivedPassword;
        boolean i = false;
        while (rs.next()) {
            receivedLoginname = rs.getString("employee_loginname");
            receivedPassword = rs.getString("employee_loginpass");
            if (receivedLoginname.equals(username) && receivedPassword.equals(password)) {
                setId(rs.getInt("employee_id"));
                if (rs.getInt("employee_isadmin") == 1) {
                    setIsAdmin(true);
                } else {
                    setIsAdmin(false);
                }
                i = true;
            }
        }
        return i;

    }

}
