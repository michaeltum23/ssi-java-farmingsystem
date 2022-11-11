/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Offer;
import farmingsystem.model.User;
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
public class OfferImpl implements OfferController{

    @Override
    public void addOffer(Offer offer) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO offer(advertisement_id,user_id,offer_price) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, offer.getAdvertisementId());
            pst.setInt(2, offer.getUserId());
            pst.setDouble(3, offer.getPriceOffer());      
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Post Success!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    
    }

    @Override
    public void updateOffer(Offer offer) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            // Parameter Index 
            String sql = "UPDATE offer SET offer_price=? WHERE offer_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            // Insert Parameter Index
            ps.setDouble(1, offer.getPriceOffer());
            System.out.println(offer.getPriceOffer());
            ps.setInt(2, offer.getOfferId());
            System.out.println(offer.getOfferId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Offer price has been changed");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    
    @Override
    public List<Offer> list() {
        List<Offer> list = new ArrayList<Offer>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM Offer ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Offer st = new Offer();
                st.setOfferId(rs.getInt("offer_id"));
                st.setAdvertisementID(rs.getInt("advertisement_id"));
                st.setUserId(rs.getInt("user_id"));
                st.setPriceOffer(rs.getDouble("offer_price"));
 
                list.add(st);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;    
    
    }

    @Override
    public Offer get(int offerId) {
        Offer st = new Offer();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM Offer WHERE offer_id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, offerId);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setOfferId(rs.getInt("offer_id"));
                st.setAdvertisementID(rs.getInt("advertisement_id"));
                st.setUserId(rs.getInt("user_id"));
                st.setPriceOffer(rs.getDouble("offer_price"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    
    }
    
}
