package com.raven.swing.table;

import farmingsystem.model.Training;
//import farmingsystem.model.User;

public class ModelActionTraining {

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public EventActionTraining getEventActionTraning() {
        return event;
    }

    public void getEventActionTraning(EventActionTraining event) {
        this.event = event;
    }

    public ModelActionTraining(Training training, EventActionTraining event) {
        this.training = training;
        this.event = event;
    }

    public ModelActionTraining() {
    }

    private Training training;
    private EventActionTraining event;
}
