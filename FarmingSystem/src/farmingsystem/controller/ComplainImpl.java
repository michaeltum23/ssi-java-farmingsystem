/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

/**
 *
 * @author FPALES
 */
import farmingsystem.FarmingConnection;
import farmingsystem.model.Complain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;
public class ComplainImpl implements ComplainController {
    
    @Override
    public void addComplain(Complain complain) {
        try
        {
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO complain(ticket_no, order_id, message, status, date_created, date_resolve, response_id, response, user_id) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, complain.getTicketNo());
            statement.setInt(2, complain.getOrderId());
            statement.setString(3, complain.getMessage());
            statement.setString(4, complain.getStatus());
            statement.setString(5, complain.getDateCreated());
            statement.setString(6, complain.getDateResolved());
            statement.setInt(7, complain.getResponse_id());
            statement.setString(8, complain.getResponse());
            statement.setInt(9, complain.getUser_id());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Complain has been sent");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void updateComplain(Complain complain) {
     try{
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE complain SET  message=?, status=?, date_resolve=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setString(1, complain.getMessage());
            statement.setString(2, complain.getStatus());
            statement.setString(3, complain.getDateResolved());
            statement.setInt(4, complain.getId());
            
//            statement.setInt(7, complain.getResponse_id());
//            statement.setString(8, complain.getResponse());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Complain has been sent");
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void deleteComplain(Complain complain) {
       try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "DELETE from complain WHERE ticket_no=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, complain.getTicketNo());
//            statement.setInt(2, complain.getOrderId());
//            statement.setString(3, complain.getMessage());
//            statement.setString(4, complain.getStatus());
//            statement.setString(5, complain.getDateCreated());
//            statement.setString(6, complain.getDateResolved());
//            statement.setInt(7, complain.getResponse_id());
//            statement.setString(8, complain.getResponse());
//            statement.setInt(9, complain.getUser_id());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleteddd!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }}

    @Override
    public Complain get(int id) {
        Complain complain = new Complain();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM complain WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                complain.setId(rs.getInt("id"));
                complain.setMessage(rs.getString("message"));
                complain.setTicketNo(rs.getString("ticket_no"));
                complain.setStatus(rs.getString("status"));
                complain.setDateCreated(rs.getString("date_created"));
                complain.setDateResolved(rs.getString("date_resolve"));
                complain.setResponse_id(rs.getInt("response_id"));
                complain.setResponse(rs.getString("response"));
                complain.setUser_id(rs.getInt("user_id"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error wit the implementation");
        }
        return complain;}

    @Override
    public List<Complain> list() {
        List<Complain> list = new ArrayList<Complain>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM complain ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                Complain pk = new Complain();
                pk.setId(rs.getInt("id"));
                pk.setMessage(rs.getString("message"));
                pk.setTicketNo(rs.getString("ticket_no"));
                pk.setStatus(rs.getString("status"));
                pk.setDateCreated(rs.getString("date_created"));
                pk.setDateResolved(rs.getString("date_resolve"));
                pk.setResponse_id(rs.getInt("response_id"));
                pk.setResponse(rs.getString("response"));
                pk.setUser_id(rs.getInt("user_id"));
                list.add(pk);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;}

    @Override
    public List<Complain> searchComplain(int user_id ,String status) {
         try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * from complain WHERE user_id=? AND status=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, status);
            ResultSet rs = ps.executeQuery();
            List<Complain> list = new ArrayList<Complain>();
            while(rs.next()){
                Complain pk = new Complain();
                pk.setId(rs.getInt("id"));
                pk.setMessage(rs.getString("message"));
                pk.setTicketNo(rs.getString("ticket_no"));
                pk.setStatus(rs.getString("status"));
                pk.setDateCreated(rs.getString("date_created"));
                pk.setDateResolved(rs.getString("date_resolve"));
                pk.setResponse_id(rs.getInt("response_id"));
                pk.setResponse(rs.getString("response"));
                 pk.setUser_id(rs.getInt("user_id"));
                list.add(pk);
            }
             return list;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }

    @Override
    public List<Complain> searchComplainByStatus(String status) {
     try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * from complain WHERE status=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            List<Complain> list = new ArrayList<Complain>();
            while(rs.next()){
                Complain pk = new Complain();
                pk.setId(rs.getInt("id"));
                pk.setMessage(rs.getString("message"));
                pk.setTicketNo(rs.getString("ticket_no"));
                pk.setStatus(rs.getString("status"));
                pk.setDateCreated(rs.getString("date_created"));
                pk.setDateResolved(rs.getString("date_resolve"));
                pk.setResponse_id(rs.getInt("response_id"));
                pk.setResponse(rs.getString("response"));
                pk.setUser_id(rs.getInt("user_id"));
                list.add(pk);
            }
             return list;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }

    @Override
    public List<Complain> searchComplainByUser(int user_id) {
     try {
          
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * from complain WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            List<Complain> list = new ArrayList<Complain>();
            while(rs.next()){
                Complain pk = new Complain();
                pk.setId(rs.getInt("id"));
                pk.setMessage(rs.getString("message"));
                pk.setTicketNo(rs.getString("ticket_no"));
                pk.setStatus(rs.getString("status"));
                pk.setDateCreated(rs.getString("date_created"));
                pk.setDateResolved(rs.getString("date_resolve"));
                pk.setResponse_id(rs.getInt("response_id"));
                pk.setResponse(rs.getString("response"));
                pk.setUser_id(rs.getInt("user_id"));
                list.add(pk);
            }
             return list;
         }
         catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }
}
