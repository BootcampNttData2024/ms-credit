package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Credit service interface.
 *
 * @author Vasquez
 * @version 1.0.
 */
public interface CreditService {

  Mono<Credit> create(Credit request);

  Mono<Credit> update(Credit request, String creditId);

  Mono<Credit> findById(String creditId);

  Flux<Credit> findAll();

  Mono<Void> deleteById(String creditId);

  Mono<Long> countByClientIdAndPaymentDueDateLessThan(String clientId);

  Mono<Credit> findByCardNumber(String cardNumber);

  Mono<Credit> modifyCreditByCardNumber(Credit request, String cardNumber);

}
