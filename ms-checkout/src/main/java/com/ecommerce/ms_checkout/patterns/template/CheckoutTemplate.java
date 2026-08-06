package com.ecommerce.ms_checkout.patterns.template;

import com.ecommerce.ms_checkout.models.Order;

public abstract class CheckoutTemplate {
    public final void performCheckout(Order order, String paymentType) {
        authUser(order);
        processDebit(order, paymentType);
        sendReceipt(order);
    }

    protected void authUser(Order order) {
        System.out.println("Verificando token de autenticação...");
        System.out.println("Cliente autorizado para a compra.");
    }

    protected void sendReceipt(Order order) {
        System.out.println("Gerando nota fiscal do pedido...");
        System.out.println("Email de confirmação enviado com sucesso!");
    }

    protected abstract void saveOrderStatus(Order order);

    protected abstract void processDebit(Order order, String paymentType);
}
