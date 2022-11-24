/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Crops;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jtamayo
 */
public class CropsImpl implements CropsController{

    @Override
    public void addCrops(Crops crops) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO crops(user_id,crop_name,crop_image, price, quantity) VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, crops.getUserID());
            pst.setString(2, crops.getCropName());
            pst.setBinaryStream(3, crops.getCropImage(), crops.getFile().length());
            pst.setDouble(4, crops.getPrice());
            pst.setDouble(5, crops.getQuantity());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Post Success!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public void updateCrops(Crops crops) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE crops SET crop_name=?,price=?,quantity=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, crops.getCropName());
            ps.setDouble(2, crops.getPrice());
            ps.setDouble(3, crops.getQuantity());
            ps.setInt(4, crops.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void deleteCrops(Crops crops) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "DELETE from crops  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, crops.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Crops get(int id) {
        Crops st = new Crops();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM crops WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setId(rs.getInt("id"));
                st.setCropName(rs.getString("crop_name"));
                st.setPrice(rs.getDouble("price"));
                st.setQuantity(rs.getDouble("quantity"));
                st.setCropImageData(rs.getBytes("crop_image"));
 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    @Override
    public List<Crops> list() {
        
        List<Crops> list = new ArrayList<Crops>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT c.id, CONCAT_WS(' ',u.first_name,u.last_name) as \"Sellername\",c.crop_name,c.price,c.quantity,c.crop_image FROM crops AS c JOIN users AS u ON c.user_id = u.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
           
            while(rs.next()){
                Crops st = new Crops();
                st.setId(rs.getInt("id"));
                st.setFullName(rs.getString("Sellername"));
                st.setCropName(rs.getString("crop_name"));
                st.setPrice(rs.getDouble("price"));
                st.setQuantity(rs.getDouble("quantity"));
                st.setCropImageData(rs.getBytes("crop_image"));
 
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
        
    }

    @Override
    public List<Crops> searchCropsByUserID(int user_id) {
        try {
           
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT c.id, CONCAT_WS(' ',u.first_name,u.last_name) as \"Sellername\",c.crop_name,c.price,c.quantity,c.crop_image FROM crops AS c JOIN users AS u ON c.user_id = u.id WHERE c.user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Crops> listCropsbyuserID = new ArrayList<Crops>();
            while(rs.next()){
                
                Crops cp = new Crops();
                cp.setId(rs.getInt("id"));
                cp.setFullName(rs.getString("Sellername"));
                cp.setCropName(rs.getString("crop_name"));
                cp.setPrice(rs.getDouble("price"));
                cp.setQuantity(rs.getDouble("quantity"));
                cp.setCropImageData(rs.getBytes("crop_image"));
 
                listCropsbyuserID.add(cp);
            }
             return listCropsbyuserID;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    
    }

   
    
    
}
