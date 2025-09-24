package com.multithreading.generics;

import com.multithreading.Order;

public class OrderRepository implements Repository<Order> {

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }
}
