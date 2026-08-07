package com.ecommerce.ms_pagamento.patterns.factory;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.ecommerce.ms_pagamento.patterns.strategy.ValidacaoStrategy;
 
/**
 * Factory: decide qual ValidacaoStrategy usar, baseado no campo "tipo".
 *
 * Truque pra não usar if/else: o Spring injeta
 * automaticamente um Map com todos os beans que implementam ValidacaoStrategy,
 * usando o nome dado em @Component("pix"), @Component("cartao") etc. como chave.
 * Ou seja, esse Map já chega pronto: { "pix": PixValidacaoStrategy, "cartao": ... }
 */

@Component
public class ValidacaoFactory {
 
    private final Map<String, ValidacaoStrategy> strategies;
 
    public ValidacaoFactory(Map<String, ValidacaoStrategy> strategies) {
        this.strategies = strategies;
    }
 
    public ValidacaoStrategy criar(String tipo) {
        ValidacaoStrategy strategy = strategies.get(tipo);
    if (strategy == null) {
        throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipo);
    }
    return strategy;
    }
}