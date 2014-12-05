/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.ConnectionParameter.CONNECTION_URL;
import static model.ConnectionParameter.DRIVER;
import static model.ConnectionParameter.PASSWORD;
import static model.ConnectionParameter.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raunak Shakya
 */
public class DBConnection {

    private Connection conn = null;

    public boolean connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            return conn;
        }
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
