/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Participants;
import farmingsystem.model.Training;
import farmingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MBATACAN
 */
public class ParticipantsImpl implements ParticipantsController{

    @Override
    public void addParticipants(Participants participants) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO participants(training_id,user_id) VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, participants.getTraining_id());
            pst.setInt(2, participants.getUser_id());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Enroll Success!");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

   

    @Override
    public List<Training> listTraining() {
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

    @Override
    public List<Participants> searchParticipantstbyTraningID(int training_id) {
       try {
           
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT CONCAT_WS(' ',users.first_name,users.last_name) as \"Participants Name\" FROM participants JOIN users ON participants.user_id = users.id WHERE participants.training_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, training_id);
            ResultSet rs = ps.executeQuery();
            List<Participants> listParticipants = new ArrayList<Participants>();
            while(rs.next()){
                
                Participants pt = new Participants();
                pt.setFull_name(rs.getString("Participants Name"));
                listParticipants.add(pt);
            }
             return listParticipants;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
        
    }

   
    
    
}
