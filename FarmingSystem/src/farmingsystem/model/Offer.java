/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import com.raven.swing.table.EventActionFarmerAdvertisement;
import com.raven.swing.table.EventActionOffer;
import com.raven.swing.table.ModelActionOffer;

/**
 *
 * @author jtamayo
 */

public class Offer {
    
    private int offerId; // primary key
    // offer Id
    private int userId; // foreign key
    private String farmerName;
    // userId
    private int advertisementId; // fk
    private String cropName;
    // advertisementId
    private String status;
    private double priceOffer; // double

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }
    
    
    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
    public Offer(String farmerName,double priceOffer) {
        this.farmerName=farmerName;
        this.priceOffer = priceOffer;
    }
    
    
    
    
    public Object[] toRowTable(EventActionOffer event) {
        return new Object[]{farmerName, priceOffer,new ModelActionOffer(this, event)};
    }
    public Offer(){
        //
    }
    
    public Offer(String cropName, double priceOffer,String status) {
        this.cropName = cropName;
        this.priceOffer = priceOffer;
        this.status = status;
    }
    
    
    public Object[] toRowTable1() {
        return new Object[]{cropName, priceOffer,status};
    }
    // contructor and parameter
    public Offer(int userId, int advertisementId, double priceOffer) {
        this.userId = userId;
        this.advertisementId = advertisementId;
        this.priceOffer = priceOffer;
    }

    public int getOfferId() {
        return offerId;
    }
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdvertisementId() {
        return advertisementId;
    }
    public void setAdvertisementID(int advertisementID) {
        this.advertisementId = advertisementID;
    }
    public double getPriceOffer() {
        return priceOffer;
    }
    public void setPriceOffer(double priceOffer) {
        this.priceOffer = priceOffer;
    }
    
}
