package com.ecommerce.ms_checkout.patterns.strategy;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.models.PaymentReturn;

public interface PaymentStrategy {
    PaymentReturn process(Order order);
}
