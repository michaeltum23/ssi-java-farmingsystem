package com.raven.swing.table;

import farmingsystem.model.User;

public class ModelActionUser {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventActionUser getEvent() {
        return event;
    }

    public void setEvent(EventActionUser event) {
        this.event = event;
    }

    public ModelActionUser(User user, EventActionUser event) {
        this.user = user;
        this.event = event;
    }

    public ModelActionUser() {
    }

    private User user;
    private EventActionUser event;
}
