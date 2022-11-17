package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Respond;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RespondImpl implements RespondController{

    @Override
    public void postResponse(Respond res) {
        try {
            Connection con =  FarmingConnection.getConnection();
            String sql = "INSERT INTO response(user_id, userid, complaint_id, response_date, response_body) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setInt(1, res.getUser_id());
            ps.setString(2, res.getUserid());
            ps.setInt(3, res.getComplaint_id());          
            ps.setString(4,res.getResponse_date());
            ps.setString(5,res.getResponse_body());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Responsed Successfully Post!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public List<Respond> list() {
        List<Respond> list = new ArrayList<Respond>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM response";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();    
            while(rs.next()){
                Respond res = new Respond(); 
                res.setId(rs.getInt("id"));
                res.setUser_id(rs.getInt("user_id"));
               // res.setUserid(rs.getString("userid"));
                res.setComplaint_id(rs.getInt("complaint_id"));                
                res.setResponse_date(rs.getString("response_date"));
                res.setResponse_body(rs.getString("response_body"));
                list.add(res);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

    @Override
    public Respond get(int ComplaintId) {
        Respond st = new Respond();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM response WHERE id=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ComplaintId);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){     
                st.setUser_id(rs.getInt("user_id"));
                st.setUserid(rs.getString("userid"));       
                st.setComplaint_id(rs.getInt("complaint_id"));           
                st.setResponse_date(rs.getString("response_date"));
                st.setResponse_body(rs.getString("response_body")); 
            }           
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;   
    }   
    
    
}
