package com.raven.swing.table;

import farmingsystem.model.Crops;

public class ModelActionCart {

    public Crops getCrop() {
        return crops;
    }

    public void setCrop(Crops crops) {
        this.crops = crops;
    }

    public EventActionCart getEvent() {
        return event;
    }

    public void setEvent(EventActionCart event) {
        this.event = event;
    }

    public ModelActionCart(Crops crops, EventActionCart event) {
        this.crops = crops;
        this.event = event;
    }

    public ModelActionCart() {
    }

    private Crops crops;
    private EventActionCart event;
}
