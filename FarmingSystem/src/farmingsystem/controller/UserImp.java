/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

}
