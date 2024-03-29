package com.vasquez.mscredit.repository;

import com.vasquez.mscredit.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Credit Card repository.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {

  Mono<Long> countByClientId(String id);

}
