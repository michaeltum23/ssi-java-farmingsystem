/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import com.raven.swing.table.ModelActionCrops;
import java.io.File;
import java.io.InputStream;
import javax.swing.Icon;
import com.raven.swing.table.EventActionCrops;
import javax.swing.JLabel;

/**
 *
 * @author jtamayo
 */
public class Crops {
    
    private int id;
    private int userID;
    private String cropName;
    private double price;
    private double quantity;
    private InputStream cropImage;
    private File file;
    private byte[] cropImageData;
    private String fullName;
    private JLabel lbl;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public Object[] toRowTable(EventActionCrops event) {
        return new Object[]{lbl,id,cropName,price,quantity,new ModelActionCrops(this, event)};
    }

    public Crops(JLabel lbl, int id, String cropName, double price, double quantity ) {
        this.id = id;
        this.cropName = cropName;
        this.price = price;
        this.quantity = quantity;
        this.lbl = lbl;
    }

    public Crops(){
        
    }

    public Crops(int id, int userID, String cropName, double price, double quantity, InputStream cropImage, File file, byte[] cropImageData) {
        this.id = id;
        this.userID = userID;
        this.cropName = cropName;
        this.price = price;
        this.quantity = quantity;
        this.cropImage = cropImage;
        this.file = file;
        this.cropImageData = cropImageData;
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

    public byte[] getCropImageData() {
        return cropImageData;
    }

    public void setCropImageData(byte[] cropImageData) {
        this.cropImageData = cropImageData;
    }
    
}
