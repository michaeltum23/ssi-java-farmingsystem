/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Training;
import java.util.List;

/**
 *
 * @author jtamayo
 */
public interface TrainingController {
    public void addTraining(Training training);
    public void updateTraining(Training training);
    public void deleteTraining(Training training);
    
    public Training get(int id);
    public List<Training>list();
}
