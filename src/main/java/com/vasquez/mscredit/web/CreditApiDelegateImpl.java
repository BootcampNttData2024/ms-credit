package com.vasquez.mscredit.web;

import com.vasquez.mscredit.api.CreditApiDelegate;
import com.vasquez.mscredit.model.CreditRequest;
import com.vasquez.mscredit.model.CreditResponse;
import com.vasquez.mscredit.service.CreditService;
import com.vasquez.mscredit.web.mapper.CreditMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditApiDelegateImpl implements CreditApiDelegate {

    private final CreditService creditService;

    public CreditApiDelegateImpl(CreditService creditService) {
        this.creditService = creditService;
    }

    @Override
    public Mono<CreditResponse> addCredit(Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
        return creditRequest.map(CreditMapper::toEntity)
                .flatMap(creditService::create)
                .map(CreditMapper::toResponse);
    }

    @Override
    public Mono<Void> deleteCreditById(String creditId, ServerWebExchange exchange) {
        return creditService.deleteById(creditId);
    }

    @Override
    public Mono<Flux<CreditResponse>> getAllCredits(ServerWebExchange exchange) {
        return Mono.just(creditService.findAll().map(CreditMapper::toResponse));
    }

    @Override
    public Mono<CreditResponse> getCreditById(String creditId, ServerWebExchange exchange) {
        return creditService.findById(creditId).map(CreditMapper::toResponse);
    }

    @Override
    public Mono<CreditResponse> updateCredit(String creditId, Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
        return creditRequest.map(CreditMapper::toEntity)
                .flatMap(cre -> creditService.update(cre, creditId))
                .map(CreditMapper::toResponse);
    }
}
