package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.DebitCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Debit card service interface.
 *
 * @author Vasquez
 * @version 1.0.
 */
public interface DebitCardService {

  Mono<DebitCard> create(DebitCard request);

  Mono<DebitCard> update(DebitCard request, String creditCardId);

  Mono<DebitCard> findById(String creditCardId);

  Flux<DebitCard> findAll();

}
