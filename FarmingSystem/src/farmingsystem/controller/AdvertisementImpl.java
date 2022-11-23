/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Advertisement;
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
public class AdvertisementImpl implements AdvertisementController{

    @Override
    public void postAds(Advertisement ads) {
        try {
            Connection con =  FarmingConnection.getConnection();
            String sql = "INSERT INTO advertisement(user_id,crop_name,quantity_needed,date_needed,status) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ads.getUserID());
            ps.setString(2, ads.getCropName());
            ps.setDouble(3, ads.getQuantityNeeded());
            ps.setString(4, ads.getDate());          
            ps.setString(5,ads.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Post!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public List<Advertisement> list() {
        List<Advertisement> list = new ArrayList<Advertisement>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT a.id,CONCAT_WS(' ',u.first_name,u.last_name) as \"Username\",a.crop_name,a.quantity_needed,a.date_needed,a.status FROM advertisement AS a JOIN users AS u ON a.user_id = u.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();           
            while(rs.next()){
                Advertisement ads = new Advertisement();
                ads.setId(rs.getInt("id"));
                ads.setFullName(rs.getString("Username"));
                ads.setCropName(rs.getString("crop_name"));
                ads.setQuantityNeeded(rs.getDouble("quantity_needed"));                
                ads.setDate(rs.getString("date_needed"));
                ads.setStatus(rs.getString("status"));
 
                list.add(ads);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    @Override
    public Advertisement get(int AdvertisementId) {
        Advertisement st = new Advertisement();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM advertisement WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, AdvertisementId);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setId(rs.getInt("id"));
                st.setCropName(rs.getString("crop_name"));
                st.setQuantityNeeded(rs.getDouble("quantity_needed"));                
                st.setDate(rs.getString("date_needed"));
                st.setStatus(rs.getString("status"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    
    }

    @Override
    public List<Advertisement> searchAdvertisementByUserID(int user_id) {
        try {
           
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT a.id, a.user_id ,CONCAT_WS(' ',u.first_name,u.last_name) as \"Username\",a.crop_name,a.quantity_needed,a.date_needed,a.status FROM advertisement AS a JOIN users AS u ON a.user_id = u.id WHERE a.user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Advertisement> listAdvertisementbyuserID = new ArrayList<Advertisement>();
            while(rs.next()){
                
                Advertisement ads = new Advertisement();
                ads.setId(rs.getInt("id"));
                ads.setUserID(rs.getInt("user_id"));
                ads.setFullName(rs.getString("Username"));
                ads.setCropName(rs.getString("crop_name"));
                ads.setQuantityNeeded(rs.getDouble("quantity_needed"));                
                ads.setDate(rs.getString("date_needed"));
                ads.setStatus(rs.getString("status"));
                listAdvertisementbyuserID.add(ads);
            }
             return listAdvertisementbyuserID;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    
    }

    @Override
    public void update(Advertisement ads) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE advertisement SET crop_name=?,quantity_needed=?,date_needed=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ads.getCropName());
            ps.setDouble(2, ads.getQuantityNeeded());
            ps.setString(3, ads.getDate());
            ps.setInt(4, ads.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void deleteAdvertisement(Advertisement ads) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "DELETE from advertisement  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, ads.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    
    }

    @Override
    public void updateStatus(Advertisement ads) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE advertisement SET status=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ads.getStatus());
            ps.setInt(2, ads.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Offer Accepted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
}
