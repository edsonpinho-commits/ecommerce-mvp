package com.ecommerce.ms_pagamento.patterns.strategy;
 
import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
 
/**
 * Regra de validação específica do Cartão.
 *
 * TODO: implementar a regra (ex: valor > 0, e o que mais fizer sentido
 * pra vocês, tipo limite máximo simulado).
 */
@Component("cartao")
public class CartaoValidacaoStrategy implements ValidacaoStrategy {
 
    @Override
    public boolean validar(PagamentoRequest request) {
        // TODO
        return false;
    }
 
    @Override
    public String getMotivoRecusa() {
        // TODO
        return null;
    }
}