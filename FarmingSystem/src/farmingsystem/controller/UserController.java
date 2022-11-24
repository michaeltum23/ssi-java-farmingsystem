/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.User;
import java.util.List;

/**
 *
 * @author MTUMANGAN
 */
public interface UserController {
    public void login(User users);
    public void register(User users);
    public void update(User users);
    public User get(String email);
    public List<User>list();
    public List<User>searchUser(String search);
    public void addAdmin(User user);
    
    public void deleteUser (User users);
    public int countCropsPost(User users);
    public double sumCrops(User users);
    public int countOffer(User users);
    public int countComplaints(User users);
  
}
