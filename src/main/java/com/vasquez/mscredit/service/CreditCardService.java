package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Credit card service interface.
 *
 * @author Vasquez
 * @version 1.0.
 */
public interface CreditCardService {

  Mono<CreditCard> create(CreditCard request);

  Mono<CreditCard> update(CreditCard request, String creditCardId);

  Mono<CreditCard> findById(String creditCardId);

  Flux<CreditCard> findAll();

  Mono<Void> deleteById(String creditCardId);

  Mono<Long> countByClientId(String clientId);

}
