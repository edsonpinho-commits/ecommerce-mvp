package com.ecommerce.ms_pagamento.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ms_pagamento.models.PagamentoRequest;
import com.ecommerce.ms_pagamento.models.PagamentoResponse;
import com.ecommerce.ms_pagamento.patterns.factory.ValidacaoFactory;
import com.ecommerce.ms_pagamento.patterns.strategy.ValidacaoResultado;
import com.ecommerce.ms_pagamento.patterns.strategy.ValidacaoStrategy;

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
        try {
            ValidacaoStrategy strategy = validacaoFactory.criar(request.getTipo());
            ValidacaoResultado resultado = strategy.validar(request);

            if (resultado.isAprovado()) {
                return ResponseEntity.ok(new PagamentoResponse("aprovado", null));
            }
            return ResponseEntity.badRequest().body(new PagamentoResponse("recusado", resultado.getMotivo()));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new PagamentoResponse("recusado", e.getMessage()));
        }
    }
}