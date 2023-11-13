package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // declare properties driver connect to mySQL
    private static final String DRIVER_JDBC = "com.mysql.cj.jdbc.Driver";
    // declare connection URL
    private static final String URL = "jdbc:mysql://localhost:3306/demo_jsp";
    // declare user property
    private static final String USER = "root";
    // declare password property
    private static final String PASSWORD = "123456";

    // get connection method
    public static Connection getConnection() {
        // declare class driver
        Connection connection = null;
        try {
            Class.forName(DRIVER_JDBC);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        // start connection
        return connection;
    }

    ;

    // close connection method
    public static void closeConnection(Connection connection)  {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(ConnectionDB.getConnection());
    }

}
