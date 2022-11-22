/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem;

import java.sql.*;

/**
 *
 * @author MTUMANGAN
 */
public class FarmingConnection {

    static Connection con;
    static String driver = "org.postgresql.Driver";
    //static String url = "jdbc:postgresql://26.100.93.148:5432/farmingdb";
    static String url = "jdbc:postgresql://localhost:5432/farmingdb";
    static String username = "postgres";
    static String password = "password";
    
    public static Connection getConnection() throws Exception {
        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
        } else {
            System.out.println("No connection");
        }
        return con;
    }
}
