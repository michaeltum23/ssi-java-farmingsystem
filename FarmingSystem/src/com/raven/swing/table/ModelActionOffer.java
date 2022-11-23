package com.raven.swing.table;

import farmingsystem.model.Advertisement;
import farmingsystem.model.Offer;

public class ModelActionOffer {

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public EventActionOffer getEvent() {
        return event;
    }

    public void setEvent(EventActionOffer event) {
        this.event = event;
    }

    public ModelActionOffer(Offer Offer, EventActionOffer event) {
        this.offer = offer;
        this.event = event;
    }

    public ModelActionOffer() {
    }

    private Offer offer;
    private EventActionOffer event;
}
