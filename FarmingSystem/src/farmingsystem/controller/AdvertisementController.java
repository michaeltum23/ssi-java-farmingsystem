/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package farmingsystem.controller;

import farmingsystem.model.Advertisement;
import java.util.List;

/**
 *
 * @author jtamayo
 */
public interface AdvertisementController {
    public void postAds(Advertisement ads);
    public List<Advertisement>list();
}
