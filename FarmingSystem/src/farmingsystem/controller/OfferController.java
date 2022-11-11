/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Offer;
import farmingsystem.model.User;
import java.util.List;

/**
 *
 * @author jtamayo
 */
public interface OfferController {
    public void addOffer(Offer offer);
    public void updateOffer(Offer offer);
    public List<Offer>list();
    public Offer get(int offerId);
    
}
