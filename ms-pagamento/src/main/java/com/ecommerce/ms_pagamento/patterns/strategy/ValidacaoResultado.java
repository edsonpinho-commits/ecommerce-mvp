package com.ecommerce.ms_pagamento.patterns.strategy;
 
/**
 * Resultado de uma validação: aprovado ou recusado (com motivo).
 * É um objeto imutável, criado do zero a cada chamada — por isso não corre
 * o risco de "vazar" dado de um pedido pra outro, mesmo com a Strategy
 * sendo um singleton do Spring.
 */
public class ValidacaoResultado {
 
    private final boolean aprovado;
    private final String motivo;
 
    private ValidacaoResultado(boolean aprovado, String motivo) {
        this.aprovado = aprovado;
        this.motivo = motivo;
    }
 
    public static ValidacaoResultado aprovado() {
        return new ValidacaoResultado(true, null);
    }
 
    public static ValidacaoResultado recusado(String motivo) {
        return new ValidacaoResultado(false, motivo);
    }
 
    public boolean isAprovado() {
        return aprovado;
    }
 
    public String getMotivo() {
        return motivo;
    }
}