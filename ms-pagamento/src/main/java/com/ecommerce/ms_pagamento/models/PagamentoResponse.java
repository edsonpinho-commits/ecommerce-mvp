package com.ecommerce.ms_pagamento.models;
 
/**
 * DTO de resposta: o que o ms-pagamento devolve pro ms-checkout.
 */
public class PagamentoResponse {
 
    private String status;  // "aprovado" ou "recusado"
    private String motivo;  // preenchido só quando status = "recusado"
 
    public PagamentoResponse() {
    }
 
    public PagamentoResponse(String status, String motivo) {
        this.status = status;
        this.motivo = motivo;
    }
 
    // TODO (opcional, deixa a resposta mais legível no Controller):
    // public static PagamentoResponse aprovado() { ... }
    // public static PagamentoResponse recusado(String motivo) { ... }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public String getMotivo() {
        return motivo;
    }
 
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}