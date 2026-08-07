package com.ecommerce.ms_pagamento.patterns.strategy;

import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;

/**
 * Regra de validação do Cartão: valor positivo + limite máximo simulado
 * por transação (regra diferente do Pix, pra mostrar de verdade por que
 * cada tipo tem sua própria Strategy).
 */
@Component("cartao")
public class CartaoValidacaoStrategy implements ValidacaoStrategy {

    private static final double LIMITE_MAXIMO = 50000.0;

    @Override
    public ValidacaoResultado validar(PagamentoRequest request) {
        if (request.getValor() == null || request.getValor() <= 0) {
            return ValidacaoResultado.recusado("Valor deve ser maior que zero");
        }
        if (request.getValor() > LIMITE_MAXIMO) {
            return ValidacaoResultado.recusado("Valor excede o limite máximo por transação no cartão");
        }
        return ValidacaoResultado.aprovado();
    }
}