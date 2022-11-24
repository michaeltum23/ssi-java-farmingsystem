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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void addOrder(Order order, User user) {
        try {
            String sql = "INSERT INTO orders(seller_id, user_id, product_name, quantity ,unit_price, seller_name) VALUES(?,?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, order.getSellerId());
            pst.setInt(2, user.getId());
            pst.setString(3, order.getProductName());
            pst.setDouble(4, order.getQuantity());
            pst.setDouble(5, order.getUnitPrice());
            pst.setString(6, order.getSellerName());
            pst.executeUpdate();
            System.out.println("Added Order");
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
        try {
            String sql = "SELECT (SELECT CONCAT(first_name,' ', last_name) FROM users WHERE id = orders.user_id) as supplier,\n"
                    + "orders.seller_name as farmer,"
                    + "(SELECT crop_name FROM crops WHERE id = orders.seller_id ) as crop, orders.quantity as quantity, "
                    + "orders.unit_price as price\n"
                    + "FROM orders";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setUserName(rs.getString("supplier"));
                o.setSellerName(rs.getString("farmer"));
                o.setProductName(rs.getString("crop"));
                o.setQuantity(rs.getDouble("price"));
                o.setUnitPrice(rs.getDouble("price"));
                list.add(o);
            }
            rs.close();
            pst.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void viewOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void addCart(Order order, User user) {
        try {
            String sql = "INSERT INTO cart(crop_id, quantity, price, user_id, seller_name) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, order.getSellerId());
            pst.setDouble(2, order.getQuantity());
            pst.setDouble(3, order.getUnitPrice());
            pst.setInt(4, user.getId());
            pst.setString(5, order.getSellerName());
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
            String sql = "SELECT s.crop_name as crop, c.seller_name as seller, c.price as price, c.quantity as quantity FROM cart as c JOIN crops as s ON c.user_id = ? AND c.crop_id = s.id";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setProductName(rs.getString("crop"));
                o.setSellerName(rs.getString("seller"));
                o.setUnitPrice(rs.getDouble("price"));
                o.setQuantity(rs.getDouble("quantity"));
                list.add(o);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public void deleteCart(User user) {
        String sql = "DELETE FROM cart WHERE user_id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getId());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
