package com.algorithms.designpatterns.solid;

// This class is responsible for processing payments.
// Breaks Open/Closed Principle (OCP) by allowing new payment methods to be
// added without modifying existing code.
public class PaymentService {
    public void processPayment(String paymentType) {
        if (paymentType.equals("credit_card")) {
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentType);
        }
    }
}

