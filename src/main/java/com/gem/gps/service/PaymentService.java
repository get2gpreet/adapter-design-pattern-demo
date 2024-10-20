package com.gem.gps.service;

import com.gem.gps.processor.PaymentProcessor;
import com.gem.gps.request.PaymentRequest;
import com.gem.gps.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final Map<String, PaymentProcessor> paymentProcessorMap;
    //PayPalAdapter , PayPalAdapter.class

    public PaymentService(List<PaymentProcessor> paymentProcessors) {
        paymentProcessorMap = paymentProcessors.stream()
                .collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
    }

    public PaymentResponse processPayment(String gateway, PaymentRequest paymentRequest) {
        PaymentProcessor paymentProcessor = paymentProcessorMap.get(gateway + "Adapter");
        paymentProcessor.makePayment(paymentRequest.amount());
        return new PaymentResponse(true, new Random().nextLong(1000000000L));
    }
}