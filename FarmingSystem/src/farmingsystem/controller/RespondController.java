/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;


import farmingsystem.model.Respond;
import java.util.List;


public interface RespondController {
    public void addRes(Respond res);
    public void updateTips(Respond tips);
    public void deleteTips (Respond tips);
    public Respond get(int id);
    public List<Respond>list();
    public List<Respond>listComplain();
    
    
    
   
}
