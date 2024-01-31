package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    Mono<Credit> create(Credit request);

    Mono<Credit> update(Credit request, String creditId);

    Mono<Credit> findById(String creditId);

    Flux<Credit> findAll();

    Mono<Void> deleteById(String creditId);

}
