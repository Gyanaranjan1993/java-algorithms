package com.algorithms.designpatterns.facade;

class PaymentService {
    public void makePayment(String item) {
        System.out.println("Processing payment for: " + item);
    }
}

