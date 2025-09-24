package com.algorithms.designpatterns.facade;

class InventoryService {
    public void checkStock(String item) {
        System.out.println("Checking stock for: " + item);
    }
}
