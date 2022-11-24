package com.raven.swing.table;

import farmingsystem.model.Crops;

public class ModelActionCrops {

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }

    public EventActionCrops getEvent() {
        return event;
    }

    public void setEvent(EventActionCrops event) {
        this.event = event;
    }

    public ModelActionCrops(Crops crops, EventActionCrops event) {
        this.crops = crops;
        this.event = event;
    }

    public ModelActionCrops() {
    }

    private Crops crops;
    private EventActionCrops event;
}
