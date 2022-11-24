/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import com.raven.swing.table.EventActionAdvertisement;
import com.raven.swing.table.ModelActionAdvertisement;

/**
 *
 * @author jtamayo
 */
public class Advertisement {
    private int id;
    private int userID;
    private String cropName;
    private double quantityNeeded;
    private String date;
    private String status;

    
    private String fullName;
    
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    public Advertisement(){
        
    }

    public Advertisement(int id, int userID, String cropName, double quantityNeeded, String date, String status) {
        this.id = id;
        this.userID = userID;
        this.cropName = cropName;
        this.quantityNeeded = quantityNeeded;
        this.date = date;
        this.status = status;
    }
    public Advertisement(int id,String cropName, double quantityNeeded, String date, String status){
        this.id=id;
        this.cropName = cropName;
        this.quantityNeeded = quantityNeeded;
        this.date = date;
        this.status = status;
    }
    
    public Object[] toRowTable(EventActionAdvertisement event) {
        return new Object[]{id,cropName,quantityNeeded, date, status,new ModelActionAdvertisement(this, event)};
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public double getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(double quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
