package com.ecommerce.ms_checkout.patterns.template;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.models.PaymentReturn;
import com.ecommerce.ms_checkout.patterns.factory.PaymentFactory;
import com.ecommerce.ms_checkout.patterns.strategy.PaymentStrategy;
import com.ecommerce.ms_checkout.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckoutProcessor extends CheckoutTemplate {
    private final PaymentFactory paymentFactory;
    private final OrderRepository orderRepository;

    public CheckoutProcessor(PaymentFactory paymentFactory, OrderRepository orderRepository) {
        this.paymentFactory = paymentFactory;
        this.orderRepository = orderRepository;
    }

    @Override
    protected void processDebit(Order order, String paymentType) {
        PaymentStrategy strategy = paymentFactory.getStrategy(paymentType);

        PaymentReturn response = strategy.process(order);

        if ("APROVADO".equals(response.getStatus())) {
            order.setStatus("PAGO");
        } else {
            order.setStatus("FALHA");
        }

        System.out.println("Resposta " + response.getStatus());
    }

    @Override
    protected void saveOrderStatus(Order order) {
        System.out.println("atualizando status pedido");

        orderRepository.save(order);

        System.out.println("Salvo");
    }
}
