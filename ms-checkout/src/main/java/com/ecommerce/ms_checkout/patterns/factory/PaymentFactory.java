package com.ecommerce.ms_checkout.patterns.factory;

import com.ecommerce.ms_checkout.patterns.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentFactory {
    private final Map<String, PaymentStrategy> strategies;

    public PaymentFactory(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy getStrategy(String paymentType) {
        return null;
    }
}
