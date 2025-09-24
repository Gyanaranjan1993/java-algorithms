package com.algorithms.designpatterns.facade;

// Facade class, which simplifies the order process by providing a single method to place an order
// clients can use this class without needing to interact with the individual services directly.
public class OrderFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public OrderFacade() {
        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
    }

    public void placeOrder(String item) {
        inventoryService.checkStock(item);
        paymentService.makePayment(item);
        shippingService.arrangeShipping(item);
    }
}
