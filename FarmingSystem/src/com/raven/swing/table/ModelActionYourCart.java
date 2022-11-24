package com.raven.swing.table;

import farmingsystem.model.Order;

public class ModelActionYourCart {

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public EventActionYourCart getEvent() {
        return event;
    }
    public void setEvent(EventActionYourCart event) {
        this.event = event;
    }
    public ModelActionYourCart(Order order, EventActionYourCart event) {
        this.order = order;
        this.event = event;
    }
    public ModelActionYourCart() {
    }

    private Order order;
    private EventActionYourCart event;
}
