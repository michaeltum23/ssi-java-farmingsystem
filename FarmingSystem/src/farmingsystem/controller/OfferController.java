/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Offer;
import java.util.List;
/**
 *
 * @author FPALES
 */
public interface OfferController {
    public void addOffer(Offer offer);
    public void updateOffer(Offer offer);
    //public void deleteOffer (Offer offer);
    public Offer get(int offerId);
    public List<Offer>list();
}
