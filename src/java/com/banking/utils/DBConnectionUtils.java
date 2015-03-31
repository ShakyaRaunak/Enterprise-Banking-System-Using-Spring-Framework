package com.banking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raunak Shakya
 */
public class DBConnectionUtils {

    public static String DRIVER = "org.postgresql.Driver";
    public static String DATABASE_NAME = "BankingSystemDB";
    public static String CONNECTION_URL = "jdbc:postgresql://localhost:5432/" + DATABASE_NAME;
    public static String USERNAME = "postgres";
    public static String PASSWORD = "niitktm";

    private Connection connection = null;

    public boolean connect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            return connection;
        }
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
