/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import farmingsystem.model.FarmingTips;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author RPAGUIO
 */
public class FarmingTipsImpl implements FarmingtipsController {

    @Override
    public void addTips(FarmingTips tips) {
        System.out.println("");
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO tips("
                    + "title, "
                    + "content)"
                    + "VALUES('"
                    + tips.getTitle() + "','"
                    + tips.getContent() + "'"
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
    public void updateTips(FarmingTips tips) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "UPDATE tips SET title=?,content=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tips.getTitle());
            ps.setString(2, tips.getContent());
            ps.setInt(3, tips.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @Override
    public void deleteTips(FarmingTips tips) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "delete from tips  WHERE id=?";
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

    public FarmingTips get(int id) {
        FarmingTips st = new FarmingTips();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM tips WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                st.setId(rs.getInt("id"));
                st.setTitle(rs.getString("title"));
                st.setContent(rs.getString("content"));
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

        return st;
    }

    @Override
    public List<FarmingTips> list() {

        List<FarmingTips> list = new ArrayList<FarmingTips>();
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "SELECT * FROM tips ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FarmingTips st = new FarmingTips();
                st.setId(rs.getInt("id"));
                st.setTitle(rs.getString("title"));
                st.setContent(rs.getString("content"));
                list.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }

}
