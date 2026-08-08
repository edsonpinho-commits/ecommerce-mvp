package com.ecommerce.ms_checkout.models;

import java.util.List;

/**
 * DTO devolvido ao cliente ao final do checkout. As etapas representam o
 * resultado do fluxo de negócio e podem ser exibidas por um futuro front-end.
 */
public record CheckoutResponse(Long pedidoId, String status, List<String> etapas) {

    public CheckoutResponse {
        etapas = List.copyOf(etapas);
    }
}
