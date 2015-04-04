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
    private UserType userType;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Boolean authenticate() {
        try {
            DBConnection dbConnection = new DBConnection();
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(
                    "SELECT * FROM employee_table");
            ResultSet rs = stmt.executeQuery();
            
            String loginName, loginPass;
            Boolean loginSucceeded = false;
            while (rs.next()) {
                loginName = rs.getString("employee_loginname");
                loginPass = rs.getString("employee_loginpass");
                if (loginName.equals(getUsername()) && loginPass.equals(getPassword())) {
                    setId(rs.getInt("employee_id"));
                    
                    String type = rs.getString("type");
                    if (type == null) {
                        throw new RuntimeException("User type not valid");
                    }
                    
                    switch (type) {
                        case "Admin":
                            setUserType(UserType.ADMIN);
                            break;
                        case "Staff":
                            setUserType(UserType.STAFF);
                            break;
                        case "Customer":
                            setUserType(UserType.CUSTOMER);
                            break;
                        default:
                            throw new RuntimeException("User type not valid");
                    }
                    loginSucceeded = true;
                }
            }
            return loginSucceeded;
        } catch (SQLException | RuntimeException exception) {

        }
        return false;
    }

}
