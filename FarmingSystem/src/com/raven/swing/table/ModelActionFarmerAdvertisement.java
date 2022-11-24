package com.raven.swing.table;

import farmingsystem.model.Advertisement;

public class ModelActionFarmerAdvertisement {

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
    

    public EventActionFarmerAdvertisement getEvent() {
        return event;
    }

    public void setEvent(EventActionFarmerAdvertisement event) {
        this.event = event;
    }

    public ModelActionFarmerAdvertisement(Advertisement advertisement, EventActionFarmerAdvertisement event) {
        this.advertisement = advertisement;
        this.event = event;
    }

    public ModelActionFarmerAdvertisement() {
    }

    private Advertisement advertisement;
    private EventActionFarmerAdvertisement event;
}
