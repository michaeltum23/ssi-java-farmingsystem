/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Order;
import java.util.List;

/**
 *
 * @author RPAGUIO
 */
public interface OrderController {

    public void addOrder(Order order);

    public Order get(int id);

    public List<Order> list();
    
    public void viewOrder();

}
