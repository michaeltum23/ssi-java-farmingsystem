/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Participants;
import farmingsystem.model.Training;
import java.util.List;

/**
 *
 * @author MBATACAN
 */
public interface ParticipantsController {
    public void addParticipants(Participants participants);
    
    public List<Participants>searchParticipantstbyTraningID(int training_id);
    public List<Training>listTraining();
   
    
}
