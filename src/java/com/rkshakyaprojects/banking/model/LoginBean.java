/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rkshakyaprojects.banking.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raunak Shakya
 */
public class LoginBean {

    private String loginname, loginpass;
    private int userID;
    private boolean isadmin, isemployee, iscustomer;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public boolean isIsemployee() {
        return isemployee;
    }

    public void setIsemployee(boolean isemployee) {
        this.isemployee = isemployee;
    }

    public boolean isIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(boolean iscustomer) {
        this.iscustomer = iscustomer;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public boolean validate() throws SQLException, ClassNotFoundException {
        DBConnection conn = new DBConnection();
        conn.connect();
        PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT * FROM employee_table");
        ResultSet rs = stmt.executeQuery();
        String receivedLoginname;
        String receivedPassword;
        boolean i = false;
        while (rs.next()) {
            receivedLoginname = rs.getString("employee_loginname");
            receivedPassword = rs.getString("employee_loginpass");
            if (receivedLoginname.equals(loginname) && receivedPassword.equals(loginpass)) {
                setUserID(rs.getInt("employee_id"));
                if (rs.getInt("employee_isadmin") == 1) {
                    setIsadmin(true);
                }else{
                    setIsadmin(false);
                }
                i = true;
            }
        }
        return i;

    }

}
