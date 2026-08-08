package com.ecommerce.ms_checkout.patterns.strategy;

import com.ecommerce.ms_checkout.models.Order;
import com.ecommerce.ms_checkout.models.PaymentReturn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service("pix")
public class PixStrategy implements PaymentStrategy {
    private final RestClient restClient = RestClient.create();

    @Override
    public PaymentReturn process(Order order) {
        Map<String, Object> payload = Map.of("valor", order.getTotal(), "tipo", "pix");

        return restClient.post().uri("http://localhost:8080/api/pagamentos").header("Tipo-Pagamento", "pix").body(payload).retrieve().body(PaymentReturn.class);
    }
}
