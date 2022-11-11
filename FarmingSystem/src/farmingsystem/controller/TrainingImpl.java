/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Training;
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
public class TrainingImpl implements TrainingController{

    @Override
    public void addTraining(Training training) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO training(title,description,schedule_date,schedule_time,training_image,status) VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, training.getTitle());
            pst.setString(2, training.getDescription());
            pst.setString(3, training.getScheduleDate());
            pst.setString(4, training.getSchedulteTime());
            pst.setBinaryStream(5, training.getTrainingImage(), training.getFile().length());
            pst.setString(6, training.getStatus());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Post Success!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void updateTraining(Training training) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE training SET title=?,description=?,schedule_date=?,schedule_time=?,status=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, training.getTitle());
            ps.setString(2, training.getDescription());
            ps.setString(3, training.getScheduleDate());
            ps.setString(4, training.getSchedulteTime());
            ps.setString(5, training.getStatus());   
            ps.setInt(6, training.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void deleteTraining(Training training) {
        try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "DELETE from training  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, training.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Training get(int id) {
        Training st = new Training();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM training WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                st.setId(rs.getInt("id"));
                st.setTitle(rs.getString("title"));
                st.setDescription(rs.getString("description"));
                st.setScheduleDate(rs.getString("schedule_date"));
                st.setSchedulteTime(rs.getString("schedule_time"));
                st.setStatus(rs.getString("status"));
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    
    }

    @Override
    public List<Training> list() {
        List<Training> list = new ArrayList<Training>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM training ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Training tr = new Training();
                tr.setId(rs.getInt("id"));
                tr.setTitle(rs.getString("title"));
                tr.setDescription(rs.getString("description"));
                tr.setScheduleDate(rs.getString("schedule_date"));
                tr.setSchedulteTime(rs.getString("schedule_time"));
                tr.setStatus(rs.getString("status"));

 
                list.add(tr);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    
    }
    
}
