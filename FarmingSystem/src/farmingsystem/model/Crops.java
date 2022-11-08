/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

/**
 *
 * @author jtamayo
 */
public class Crops {
    
    private int id;
//    private User userID;
    private String cropName;
//    private String cropImage;
    private double price;
    private double quantity;
    
    public Crops(){
        
    }

    public Crops(int id, String cropName, double price, double quantity) {
        this.id = id;
        this.cropName = cropName;
        this.price = price;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    
    
    
    

    
        
    
}
