package com.algorithms.designpatterns.solid;

public class DebitCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(String paymentType) {
        if (paymentType.equals("debit_card")) {
            System.out.println("Processing debit card payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentType);
        }
    }
}
