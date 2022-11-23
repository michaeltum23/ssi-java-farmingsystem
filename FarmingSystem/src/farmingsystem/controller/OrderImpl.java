/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
