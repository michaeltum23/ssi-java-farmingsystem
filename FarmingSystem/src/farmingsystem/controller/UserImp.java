/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MTUMANGAN
 */
public class UserImp implements UserController {

    @Override
    public void login(User users) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM tbl_user";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            String username = "";
            String password = "";
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                System.out.println(username);
                System.out.println(password);
                if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed");
                }
            }
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
