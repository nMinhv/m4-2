package com.example.util;

import com.example.model.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.graalvm.compiler.options.OptionType.User;

public class ConnectionDB  {
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/thymeleaf_demo";
        private static final String USER = "root";
        private static final String PASSWORD = "123456";
    public static Connection openConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static void main(String[] args) {
        System.out.println("@Htfcirts02".matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"));
        System.out.println("+84 0987654321".matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"));
        com.example.model.entity.User user = new User();
        System.out.println(user.getUserId());
    }
}
