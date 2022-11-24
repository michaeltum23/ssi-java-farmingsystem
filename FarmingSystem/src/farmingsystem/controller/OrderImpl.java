/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Order;
import farmingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RPAGUIO
 */
public class OrderImpl implements OrderController {

    private Connection con;

    public OrderImpl() {
        try {
            con = FarmingConnection.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addOrder(Order order) {
        try {
            String sql = "INSERT INTO orders(seller_id, user_id, product_name, quantity ,unit_price) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, order.getSellerId());
            pst.setInt(2, order.getUserId());
            pst.setString(3, order.getProductName());
            pst.setDouble(4, order.getQuantity());
            pst.setDouble(5, order.getUnitPrice());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Post Success!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    @Override
    public Order get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order> list() {
        List<Order> list = new ArrayList<Order>();
//        try{
//            String sql = "SELECT";
//        }
        return list;
    }

    @Override
    public void viewOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addCart(Order order, User user) {
        try {
            String sql = "INSERT INTO cart(crop_id, quantity, price, user_id) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, order.getSellerId());
            pst.setDouble(2, order.getQuantity());
            pst.setDouble(3, order.getUnitPrice());
            pst.setInt(4, user.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Order> listCart(User user) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT s.crop_name as crop, c.price as price, c.quantity as quantity FROM cart as c JOIN crops as s ON c.user_id = ? AND c.crop_id = s.id";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setProductName(rs.getString("crop"));
                o.setUnitPrice(rs.getDouble("price"));
                o.setQuantity(rs.getDouble("quantity"));
                list.add(o);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
