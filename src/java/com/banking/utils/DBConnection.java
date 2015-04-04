package com.banking.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raunak Shakya
 */
public class DBConnection {

    private Connection connection;
    
    public DBConnection() {
        try {
            Class.forName(DatabaseParameters.DRIVER);
            connection = DriverManager.getConnection(
                    DatabaseParameters.CONNECTION_URL, 
                    DatabaseParameters.USERNAME, 
                    DatabaseParameters.PASSWORD
            );
        } catch (ClassNotFoundException | SQLException exception) {
            
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
