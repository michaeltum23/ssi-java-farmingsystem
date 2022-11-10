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
            String sql = "INSERT INTO users(username, password, first_name, middle_name, last_name, gender, birthday, contact_number, house_no, street_address, city_address, valid_id, email, user_type, active, user_id, profile_image) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getUsername());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getFirstName());
            pst.setString(4, users.getMiddleName());
            pst.setString(5, users.getLastName());
            pst.setString(6, users.getGender());
            pst.setString(7, users.getBirthDate());
            pst.setString(8, users.getContactNumber());
            pst.setString(9, users.getHouseNo());
            pst.setString(10, users.getStreetAddress());
            pst.setString(11, users.getCityAddress());
            pst.setBytes(12, null);
            pst.setString(13, users.getEmail());
            pst.setString(14, users.getUserType());
            pst.setBoolean(15, users.getActive());
            pst.setString(16, users.getUserId());
            pst.setBinaryStream(17, users.getProfielImage(), users.getFile().length());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTERED!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    
    @Override
    public void update(User users) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE users SET username=?,password=?,first_name=?,middle_name=?,last_name=?,birthday=?,contact_number=?,house_no=?,street_address=?,city_address =?,email=? WHERE user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,users.getUsername());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getFirstName());
            pst.setString(4, users.getMiddleName());
            pst.setString(5, users.getLastName()); 
            pst.setString(6, users.getBirthDate());
            pst.setString(7, users.getContactNumber());
            pst.setString(8, users.getHouseNo());
            pst.setString(9, users.getStreetAddress());
            pst.setString(10, users.getCityAddress());
            pst.setString(11, users.getEmail());
            
            pst.setString(12, users.getUserId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATED!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    @Override
    public User get(String userId) {
        User st = new User();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM users WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setUserId(rs.getString("user_id"));
                st.setUsername(rs.getString("username"));
                st.setPassword(rs.getString("password"));
                st.setFirstName(rs.getString("first_name"));
                st.setMiddleName(rs.getString("middle_name"));
                st.setLastName(rs.getString("last_name"));
                st.setBirthDate(rs.getString("birthday"));
                st.setContactNumber(rs.getString("contact_number"));
                st.setHouseNo(rs.getString("house_no"));
                st.setStreetAddress(rs.getString("street_address"));
                st.setCityAddress(rs.getString("city_address"));
                st.setEmail(rs.getString("email"));
             
                
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    @Override
    public List<User> list() {
        
        List<User> list = new ArrayList<User>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM users ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                User st = new User();
                st.setUserId(rs.getString("user_id"));
                st.setUsername(rs.getString("username"));
                st.setPassword(rs.getString("password"));
                st.setFirstName(rs.getString("first_name"));
                st.setMiddleName(rs.getString("middle_name"));
                st.setLastName(rs.getString("last_name"));
                st.setBirthDate(rs.getString("birthday"));
                st.setContactNumber(rs.getString("contact_number"));
                st.setHouseNo(rs.getString("house_no"));
                st.setStreetAddress(rs.getString("street_address"));
                st.setCityAddress(rs.getString("city_address"));
                st.setEmail(rs.getString("email"));
                st.setUserType(rs.getString("user_type"));
 
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
        
    }


   

}
