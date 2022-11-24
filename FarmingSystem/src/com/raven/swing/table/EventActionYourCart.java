package com.raven.swing.table;

import farmingsystem.model.Order;

public interface EventActionYourCart {

    public void Add(Order order);

    public void Minus(Order order);
    
    public void RemoveCart(Order order);
}
