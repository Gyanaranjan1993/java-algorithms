package com.algorithms.designpatterns.solid;

// This class is responsible for processing credit card payments.
// Follows OCP by implementing the PaymentProcessor interface,
// allowing for new payment methods to be added without modifying existing code.
// New PaymentProcessor implementations can be created for other payment methods.
public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(String paymentType) {
        if (paymentType.equals("credit_card")) {
            System.out.println("Processing credit card payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + paymentType);
        }
    }
}
