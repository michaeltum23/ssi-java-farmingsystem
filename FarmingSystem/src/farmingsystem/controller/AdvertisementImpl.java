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
            String sql = "SELECT * FROM advertisement ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Advertisement ads = new Advertisement();
                ads.setId(rs.getInt("id"));
                ads.setUserID(rs.getInt("user_id"));
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
    
}
