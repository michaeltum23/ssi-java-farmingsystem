/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

/**
 *
 * @author FPALES
 */
public class Offer {
    private int offerId; // primary key
    // offer Id
    private int userId; // foreign key
    // userId
    private int advertisementId; // fk
    // advertisementId
    private double priceOffer; // double
    
    public Offer(){
        //
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
