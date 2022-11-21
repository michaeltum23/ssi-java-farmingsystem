/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.FarmingConnection;
import farmingsystem.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;


public class OrderImpl implements OrderController {
    @Override
    public void addOrder(Order order) {
        try{
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO orders(seller_id, user_id, product_name, quantity ,unit_price) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
//            String sql = "INSERT INTO order("
//                    + "seller_id, "
//                    + "user_id, "
//                    + "product_name, "
//                    + "quantity, "
//                    + "unit_price)"
//                    + "VALUES('"
//                    + order.getSellerId() + "','"   
//                    + order.getUserId() + "','" 
//                    + order.getProductName() + "','"
//                    + order.getUnitPrice() + "','"
//                    + order.getQuantity()+ "'"
//                    + ")";
            
            pst.setInt(1, order.getSellerId());
            pst.setInt(2, order.getUserId());
            pst.setString(3, order.getProductName());
            pst.setDouble(4, order.getQuantity());
            pst.setDouble(5, order.getUnitPrice());
            pst.executeUpdate();  
            JOptionPane.showMessageDialog(null, "Post Success!");
        }catch(Exception e){
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
