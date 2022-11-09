/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

/**
 *
 * @author jtamayo
 */
public class Advertisement {
    private int id;
//    private User userID;
    private String cropName;
//    private String cropImage;
    private double quantityNeeded;
    private String date;
//    private List Offer;//object variable
    private String status;
    
    public Advertisement(){
        
    }

    public Advertisement(int id, String cropName, double quantityNeeded, String date, String status) {
        this.id = id;
        this.cropName = cropName;
        this.quantityNeeded = quantityNeeded;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
