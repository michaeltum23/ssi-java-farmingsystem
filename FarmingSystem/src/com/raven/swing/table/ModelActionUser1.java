package com.raven.swing.table;

import farmingsystem.model.FarmingTips;


public class ModelActionUser1 {

    public FarmingTips getFarmingTips() {
        return tips;
    }

    public void setUser(FarmingTips tips) {
        this.tips = tips;
    }

    public EventActionUser1 getEvent() {
        return event;
    }

    public void setEvent(EventActionUser1 event) {
        this.event = event;
    }

    public ModelActionUser1(FarmingTips tips, EventActionUser1 event) {
        this.tips = tips;
        this.event = event;
    }

    public ModelActionUser1() {
    }

    private FarmingTips tips;
    private EventActionUser1 event;
}
