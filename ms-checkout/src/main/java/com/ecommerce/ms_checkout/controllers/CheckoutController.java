package com.ecommerce.ms_checkout.controllers;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.patterns.template.CheckoutProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private final CheckoutProcessor checkoutProcessor;

    public CheckoutController(CheckoutProcessor checkoutProcessor) {
        this.checkoutProcessor = checkoutProcessor;
    }

    @PostMapping
    public ResponseEntity<String> finishBuy(@RequestBody Order order, @RequestParam String type) {
        checkoutProcessor.performCheckout(order, type.toUpperCase());

        return ResponseEntity.ok("Checkout finalizado!");
    }
}
