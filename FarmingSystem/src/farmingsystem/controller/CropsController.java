/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Crops;
import java.util.List;

/**
 *
 * @author jtamayo
 */
public interface CropsController {
    public void addCrops(Crops crops);
    public void updateCrops(Crops crops);
    public void deleteCrops (Crops crops);
    public Crops get(int id);
    public List<Crops>list();
    
}
