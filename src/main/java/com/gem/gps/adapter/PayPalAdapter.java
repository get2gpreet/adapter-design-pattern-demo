package com.gem.gps.adapter;

import com.gem.gps.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class PayPalAdapter implements PaymentProcessor {

    public void makePayment(double amount) {
        // PayPal-specific logic to process payment
        //actual api
        System.out.println("Payment processed via PayPal: " + amount);
    }
}
