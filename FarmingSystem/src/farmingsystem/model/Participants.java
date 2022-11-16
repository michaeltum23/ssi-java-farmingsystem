/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

/**
 *
 * @author MBATACAN
 */
public class Participants {
    private int training_id;
    private int user_id;
    
    public Participants(){

}

    public Participants(int training_id, int user_id) {
        this.training_id = training_id;
        this.user_id = user_id;
    }
  
    public int getTraining_id() {
        return training_id;
    }

    public int getUser_id() {
        return user_id;
    }
    
    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
}
