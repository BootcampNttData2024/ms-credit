package com.vasquez.mscredit.controller;

import com.vasquez.mscredit.api.CreditApi;
import com.vasquez.mscredit.model.CreditRequest;
import com.vasquez.mscredit.model.CreditResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CreditRestController implements CreditApi {

    @Override
    public Mono<CreditResponse> addCredit(Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Void> deleteCreditById(Integer creditId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Flux<CreditResponse>> getAllCredits(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<CreditResponse> getCreditById(String creditId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<CreditResponse> updateCredit(String creditId, Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
        return null;
    }
}
