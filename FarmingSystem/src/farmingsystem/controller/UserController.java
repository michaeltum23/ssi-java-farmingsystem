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
    
    public void deleteUser (User users);
   
  
}
