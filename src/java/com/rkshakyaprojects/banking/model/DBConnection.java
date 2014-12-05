package com.rkshakyaprojects.banking.model;

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
            Class.forName(ConnectionParameter.DRIVER);
            conn = DriverManager.getConnection(ConnectionParameter.CONNECTION_URL, ConnectionParameter.USERNAME, ConnectionParameter.PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(ConnectionParameter.DRIVER);
            conn = DriverManager.getConnection(ConnectionParameter.CONNECTION_URL, ConnectionParameter.USERNAME, ConnectionParameter.PASSWORD);
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
