package com.ecommerce.ms_pagamento.patterns.strategy;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;

/**
 * Strategy: cada tipo de pagamento tem sua própria regra de validação.
 * Quem usa essa interface (o Controller, via Factory) não precisa saber
 * qual regra está rodando por trás — só chama validar() e olha o resultado.
 */
public interface ValidacaoStrategy {

    ValidacaoResultado validar(PagamentoRequest request);
}