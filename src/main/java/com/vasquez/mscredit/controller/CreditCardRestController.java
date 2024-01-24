package com.vasquez.mscredit.controller;

import com.vasquez.mscredit.api.CreditCardApi;
import com.vasquez.mscredit.model.CreditCardRequest;
import com.vasquez.mscredit.model.CreditCardResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CreditCardRestController implements CreditCardApi {

    @Override
    public Mono<CreditCardResponse> addCreditCard(Mono<CreditCardRequest> creditCardRequest, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Void> deleteCreditCardById(String creditCardId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<Flux<CreditCardResponse>> getAllCreditCard(ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<CreditCardResponse> getCreditCardById(String creditCardId, ServerWebExchange exchange) {
        return null;
    }

    @Override
    public Mono<CreditCardResponse> updateCreditCard(String creditCardId, Mono<CreditCardRequest> creditCardRequest, ServerWebExchange exchange) {
        return null;
    }
}
