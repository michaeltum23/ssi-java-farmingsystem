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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MTUMANGAN
 */
public class UserImp implements UserController {

    @Override
    public void login(User users) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username='"
                    + users.getUsername() + "'and password='" + users.getPassword() + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(users.getUsername());
            System.out.println(users.getPassword());
            if (rs.next()) {
                System.out.println("Login Successfull");
                JOptionPane.showMessageDialog(null, "Login Succesful");
            }else{
                System.out.println("what");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void register(User users) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO users("
                    + "username, "
                    + "password,"
                    + "first_name,"
                    + "middle_name,"
                    + "last_name,"
                    + "gender,"
                    + "birthday,"
                    + "contact_number,"
                    + "house_no,"
                    + "street_address,"
                    + "city_address,"
                    + "profile_image,"
                    + "valid_id,"
                    + "email,"
                    + "user_type,"
                    + "active,"
                    + "user_id)"
                    + "VALUES('"
                    + users.getUsername() + "','"
                    + users.getPassword()+ "','"
                    + users.getFirstName()+ "','"
                    + users.getMiddleName()+ "','"
                    + users.getLastName()+ "','"
                    + users.getGender()+ "','"
                    + users.getBirthDate()+ "','"
                    + users.getContactNumber()+ "','"
                    + users.getHouseNo()+ "','"
                    + users.getStreetAddress()+ "','"
                    + users.getCityAddress()+ "','"
                    + users.getProfielImage()+ "','"
                    + users.getValidId()+ "','"
                    + users.getEmail()+ "','"
                    + users.getUserType()+ "','"
                    + users.getActive()+ "','"
                    + users.getUserId()+ "'"
                    + ")";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTERED!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public List<User> list() {
     List<User> list = new ArrayList<>();
      try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM users ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User us = new User();
                us.setId(rs.getInt("id"));
                us.setUsername(rs.getString("username")); 
                us.setPassword(rs.getString("password"));
                
                us.setFirstName(rs.getString("first_name"));
                us.setMiddleName(rs.getString("middle_name"));
                us.setLastName(rs.getString("last_name"));
                us.setGender(rs.getString("gender"));
                
                us.setBirthDate(rs.getString("birthday"));
                us.setContactNumber(rs.getString("contact_number"));
                us.setHouseNo(rs.getString("house_no"));
                us.setStreetAddress(rs.getString("street_address"));
                us.setCityAddress(rs.getString("city_address"));
                
                // us.setProfielImage(rs.getByte("profile_image"));
                
                
                us.setEmail(rs.getString("email"));
                us.setUserType(rs.getString("user_type"));
                us.setActive(rs.getBoolean("active"));
                us.setUserId(rs.getString("user_id"));
                                
                 
               
               

 
                list.add(us);
            }     
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

}
