package com.raven.swing.table;

import farmingsystem.model.Complain;

public class ModelActionSupplierComplain {

    public Complain getComplain() {
        return complain;
    }

    public void setComplain(Complain complain) {
        this.complain = complain;
    }

    public EventActionSupplierComplain getEvent() {
        return event;
    }

    public void setEvent(EventActionSupplierComplain event) {
        this.event = event;
    }

    public ModelActionSupplierComplain(Complain complain, EventActionSupplierComplain event) {
        this.complain = complain;
        this.event = event;
    }

    public ModelActionSupplierComplain() {
    }

    private Complain complain;
    private EventActionSupplierComplain event;
}
