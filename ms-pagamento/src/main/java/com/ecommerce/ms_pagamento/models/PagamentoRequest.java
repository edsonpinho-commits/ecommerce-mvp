package com.ecommerce.ms_pagamento.models;
 
/**
 * DTO que representa o que o ms-checkout envia pra cá.
 * O ms-pagamento não sabe nada sobre cliente/carrinho/produto —
 * só recebe valor e tipo.
 */
public class PagamentoRequest {
 
    private Double valor;
    private String tipo; // "pix", "cartao" ou "boleto"
 
    public PagamentoRequest() {
    }
 
    public Double getValor() {
        return valor;
    }
 
    public void setValor(Double valor) {
        this.valor = valor;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}