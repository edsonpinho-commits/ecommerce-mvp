package com.ecommerce.ms_pagamento.patterns.strategy;

import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;

/**
 * Regra de validação do Pix: só precisa que o valor seja positivo.
 */
@Component("pix")
public class PixValidacaoStrategy implements ValidacaoStrategy {

    @Override
    public ValidacaoResultado validar(PagamentoRequest request) {
        if (request.getValor() == null || request.getValor() <= 0) {
            return ValidacaoResultado.recusado("Valor deve ser maior que zero");
        }
        return ValidacaoResultado.aprovado();
    }
}