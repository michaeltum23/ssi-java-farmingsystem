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
            String sql = "INSERT INTO advertisement(crop_name,quantity_needed,date_needed) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ads.getCropName());
            ps.setDouble(2, ads.getQuantityNeeded());
            ps.setString(3, ads.getDate());
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
                ads.setCropName(rs.getString("crop_name"));
                ads.setQuantityNeeded(rs.getDouble("quantity_needed"));                
                ads.setDate(rs.getString("date_needed"));
 
                list.add(ads);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
    
}
