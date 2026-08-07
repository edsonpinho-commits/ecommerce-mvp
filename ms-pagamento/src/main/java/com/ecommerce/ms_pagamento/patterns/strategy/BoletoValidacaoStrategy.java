package com.ecommerce.ms_pagamento.patterns.strategy;
 
import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
 
/**
 * Regra de validação específica do Boleto.
 *
 * TODO: implementar a regra (ex: valor > 0).
 */
@Component("boleto")
public class BoletoValidacaoStrategy implements ValidacaoStrategy {
 
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