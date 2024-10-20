package com.gem.gps.adapter;

import com.gem.gps.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class StripeAdapter implements PaymentProcessor {

    public void makePayment(double amount) {
        // Stripe-specific logic to process payment
        System.out.println("Payment processed via Stripe: " + amount);
    }
}
