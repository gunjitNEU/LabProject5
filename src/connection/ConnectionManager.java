/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;

/**
 *
 * @author imkus
 */
public class ConnectionManager {

    private static final String url = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String username = "hospital_management";
    private static final String password = "pass123";

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                return DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return null;
    }
}
