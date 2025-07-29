package com.algorithms.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String symbol;
    private double price;
    private List<Observer> observers;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Stock " + symbol + " price updated to " + price);
        }
    }
}
