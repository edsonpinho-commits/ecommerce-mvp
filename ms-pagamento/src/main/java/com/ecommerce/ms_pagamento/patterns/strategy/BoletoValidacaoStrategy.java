package com.ecommerce.ms_pagamento.patterns.strategy;
 
import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
 
/**
 * Regra de validação do Boleto: valor positivo + valor mínimo simulado
 * (bancos costumam ter um mínimo pra emitir boleto).
 */
@Component("boleto")
public class BoletoValidacaoStrategy implements ValidacaoStrategy {
 
    private static final double VALOR_MINIMO = 5.0;
 
    @Override
    public ValidacaoResultado validar(PagamentoRequest request) {
        if (request.getValor() == null || request.getValor() <= 0) {
            return ValidacaoResultado.recusado("Valor deve ser maior que zero");
        }
        if (request.getValor() < VALOR_MINIMO) {
            return ValidacaoResultado.recusado("Valor abaixo do mínimo permitido para boleto");
        }
        return ValidacaoResultado.aprovado();
    }
}