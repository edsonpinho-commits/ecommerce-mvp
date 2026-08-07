package com.ecommerce.ms_pagamento.patterns.strategy;
 
import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
 
/**
 * Regra de validação específica do Pix.
 * O nome dado ao @Component ("pix") é a chave que a Factory vai usar
 * pra encontrar essa strategy — precisa bater com o campo "tipo" do request.
 *
 * TODO: implementar a regra (ex: valor > 0).
 */
@Component("pix")
public class PixValidacaoStrategy implements ValidacaoStrategy {
 
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