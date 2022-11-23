package com.raven.swing.table;

import farmingsystem.model.Advertisement;

public class ModelActionAdvertisement {

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    public EventActionAdvertisement getEvent() {
        return event;
    }

    public void setEvent(EventActionAdvertisement event) {
        this.event = event;
    }

    public ModelActionAdvertisement(Advertisement advertisement, EventActionAdvertisement event) {
        this.advertisement = advertisement;
        this.event = event;
    }

    public ModelActionAdvertisement() {
    }

    private Advertisement advertisement;
    private EventActionAdvertisement event;
}
