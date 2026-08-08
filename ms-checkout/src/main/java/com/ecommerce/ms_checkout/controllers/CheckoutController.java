package com.ecommerce.ms_checkout.controllers;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.patterns.template.CheckoutProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private final CheckoutProcessor checkoutProcessor;

    public CheckoutController(CheckoutProcessor checkoutProcessor) {
        this.checkoutProcessor = checkoutProcessor;
    }

    @PostMapping
    public ResponseEntity<String> finishBuy(@RequestBody CheckoutRequest request) {
        if (request.valor() == null || request.valor() <= 0) {
            return ResponseEntity.badRequest().body("O valor do pedido deve ser maior que zero.");
        }
        if (request.tipo() == null || request.tipo().isBlank()) {
            return ResponseEntity.badRequest().body("O tipo de pagamento é obrigatório.");
        }

        Order order = new Order();
        order.setTotal(request.valor());

        String paymentType = request.tipo() == null
                ? null
                : request.tipo().trim().toLowerCase(Locale.ROOT);

        try {
            checkoutProcessor.executeCheckout(order, paymentType);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        if ("FALHA".equals(order.getStatus())) {
            return ResponseEntity.unprocessableEntity().body("Pagamento recusado.");
        }

        return ResponseEntity.ok("Checkout finalizado!");
    }
}
record CheckoutRequest(Double valor, String tipo) {}
