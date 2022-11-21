package com.raven.swing.table;

import farmingsystem.model.User;


public interface EventActionSupplier {

    public void delete(User user);

    public void update(User user);
}
