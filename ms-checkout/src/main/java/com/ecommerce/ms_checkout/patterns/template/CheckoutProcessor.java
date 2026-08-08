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
    protected PaymentReturn processDebit(Order order, String paymentType) {
        PaymentStrategy strategy = paymentFactory.getStrategy(paymentType);
        return strategy.process(order);
    }

    @Override
    protected void saveOrderStatus(Order order) {
        System.out.println("atualizando status pedido");

        orderRepository.save(order);

        System.out.println("Salvo");
    }
}
