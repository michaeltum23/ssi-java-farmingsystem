/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Complain;
import java.util.List;

/**
 *
 * @author FPALES
 */
public interface ComplainController {
    public void addComplain(Complain complain);
    public void updateComplain(Complain complain);
    public void deleteComplain(Complain complain);
    public List<Complain> searchComplain(int user_id, String status);
    public List<Complain> searchComplainByStatus(String status);
    public List<Complain> searchComplainByUser(int user_id);
    public Complain get(int id);
    public List<Complain>list();
}
