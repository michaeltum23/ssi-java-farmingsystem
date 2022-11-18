/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import farmingsystem.model.Respond;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RPAGUIO
 */
public class RespondImpl implements RespondController {

    @Override
    public void addRes(Respond res) {
        System.out.println("");
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO response("
                    + "user_id, "
                     + "complaint_id, "
                    + "response_date, "
                    + "response_body)"
                    + "VALUES('"
                    + res.getUser_id()+ "','"
                    + res.getComplaint_id() + "','"  
                    + res.getResponse_date()+ "','"   
                    + res.getResponse_body()+ "'"
                    + ")";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @Override
    public void updateTips(Respond tips) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE response SET response_date=?, response_body=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tips.getResponse_date());
            ps.setString(2, tips.getResponse_body()); 
            ps.setInt(3, tips.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
      }

    }

    @Override
    public void deleteTips(Respond tips) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "delete from response  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, tips.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @Override

    public Respond get(int id) {
        Respond st = new Respond();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM response WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){            
                st.setId(rs.getInt("id"));
              //  st.setUser_id(rs.getString("user_id"));
                st.setResponse_body(rs.getString("response_body"));
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

        return st;
    }

    @Override
    public List<Respond> list() {
            
            List<Respond> list = new ArrayList<Respond>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM response ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Respond st = new Respond();
                st.setId(rs.getInt("id"));
               
                st.setUser_id(rs.getInt("user_id"));
                st.setComplaint_id(rs.getInt("complaint_id"));
                st.setResponse_date(rs.getString("response_date"));
                st.setResponse_body(rs.getString("response_body"));
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
       return list;
    }

    @Override
    public List<Respond> listComplain() {
            
            List<Respond> listComplain = new ArrayList<Respond>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM complain ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Respond complain = new Respond();
               complain.setComplaint_id(rs.getInt("id"));
               complain.setComplaint_user_id(rs.getInt("user_id"));
               complain.setComplaint_message(rs.getString("message"));
               listComplain.add(complain);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
       return listComplain;  }
    
    
   

    
}
