/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;


import farmingsystem.model.FarmingTips;
import java.util.List;


public interface FarmingtipsController {
    public void addTips(FarmingTips tips);
    public void updateTips(FarmingTips tips);
    public void deleteTips (FarmingTips tips);
    public FarmingTips get(int id);
    public List<FarmingTips>list();
}
