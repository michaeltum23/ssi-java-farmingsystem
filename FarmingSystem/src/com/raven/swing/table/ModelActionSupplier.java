package com.raven.swing.table;

import farmingsystem.model.User;

public class ModelActionSupplier {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventActionSupplier getEvent() {
        return event;
    }

    public void setEvent(EventActionSupplier event) {
        this.event = event;
    }

    public ModelActionSupplier(User user, EventActionSupplier event) {
        this.user = user;
        this.event = event;
    }

    public ModelActionSupplier() {
    }

    private User user;
    private EventActionSupplier event;
}
