package com.ecommerce.ms_pagamento.controllers;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
import com.ecommerce.ms_pagamento.models.PagamentoResponse;
import com.ecommerce.ms_pagamento.patterns.factory.ValidacaoFactory;
 
/**
 * Recebe o POST do ms-checkout, valida usando a Strategy certa
 * (escolhida pela Factory) e devolve 200 (aprovado) ou 400 (recusado).
 */
@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
 
    private final ValidacaoFactory validacaoFactory;
 
    public PagamentoController(ValidacaoFactory validacaoFactory) {
        this.validacaoFactory = validacaoFactory;
    }
 
    @PostMapping
    public ResponseEntity<PagamentoResponse> processar(@RequestBody PagamentoRequest request) {
        // TODO:
        // 1. ValidacaoStrategy strategy = validacaoFactory.criar(request.getTipo());
        // 2. if (strategy.validar(request)) -> ResponseEntity.ok(new PagamentoResponse("aprovado", null))
        // 3. senao -> ResponseEntity.badRequest().body(new PagamentoResponse("recusado", strategy.getMotivoRecusa()))
        return null;
    }
}