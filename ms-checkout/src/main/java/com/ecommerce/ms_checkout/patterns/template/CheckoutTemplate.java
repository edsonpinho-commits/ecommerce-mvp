package com.ecommerce.ms_checkout.patterns.template;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.ms_checkout.models.CheckoutResponse;
import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.models.PaymentReturn;

public abstract class CheckoutTemplate {
    public final CheckoutResponse executeCheckout(Order order, String paymentType) {
        List<String> etapas = new ArrayList<>();

        authUser(order);
        etapas.add("Cliente autorizado para a compra.");

        PaymentReturn response = processDebit(order, paymentType);

        if (response != null && "aprovado".equalsIgnoreCase(response.getStatus())) {
            order.setStatus("PAGO");
            etapas.add("Resposta aprovado.");
        } else {
            order.setStatus("FALHA");
            String motivo = response == null ? "Não foi possível obter resposta do pagamento." : response.getMotivo();
            etapas.add("Resposta recusado" + (motivo == null ? "." : ": " + motivo));
        }

        etapas.add("Atualizando status do pedido.");
        saveOrderStatus(order);
        etapas.add("Pedido salvo com sucesso.");

        if ("PAGO".equals(order.getStatus())) {
            sendReceipt(order);
            etapas.add("Nota fiscal gerada.");
            etapas.add("E-mail de confirmação enviado com sucesso.");
        }

        return new CheckoutResponse(order.getId(), order.getStatus(), etapas);
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

    protected abstract PaymentReturn processDebit(Order order, String paymentType);
}
