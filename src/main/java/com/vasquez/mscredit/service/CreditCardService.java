package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.entity.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    Mono<CreditCard> create(CreditCard request);

    Mono<CreditCard> update(CreditCard request, String creditCardId);

    Mono<CreditCard> findById(String creditCardId);

    Flux<CreditCard> findAll();

    Mono<Void> deleteById(String creditCardId);

    Mono<Integer> countByClientId(String clientId);

}
