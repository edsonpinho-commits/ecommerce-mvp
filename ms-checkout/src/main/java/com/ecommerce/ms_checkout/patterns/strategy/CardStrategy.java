package com.ecommerce.ms_checkout.patterns.strategy;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.models.PaymentReturn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service("CARTAO")
public class CardStrategy implements PaymentStrategy {
    private final RestClient restClient = RestClient.create();

    @Override
    public PaymentReturn process(Order order) {
        PaymentReturn response = restClient.post().uri("http://localhost:8080/api/pagamentos").header("Tipo-Pagamento", "CARTAO").body(order).retrieve().body(PaymentReturn.class);
        return response;
    }
}
