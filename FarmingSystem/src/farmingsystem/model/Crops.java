/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author jtamayo
 */
public class Crops {
    
    private int id;
//    private User userID;
    private String cropName;
    private double price;
    private double quantity;
    private InputStream cropImage;
    private File file;
    
    public Crops(){
        
    }

    public Crops(int id, String cropName, double price, double quantity, InputStream cropImage, File file) {
        this.id = id;
        this.cropName = cropName;
        this.price = price;
        this.quantity = quantity;
        this.cropImage = cropImage;
        this.file = file;
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

    public InputStream getCropImage() {
        return cropImage;
    }

    public void setCropImage(InputStream cropImage) {
        this.cropImage = cropImage;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
    
        
    
}
