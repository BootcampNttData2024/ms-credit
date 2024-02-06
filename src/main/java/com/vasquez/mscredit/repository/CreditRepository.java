package com.vasquez.mscredit.repository;

import com.vasquez.mscredit.entity.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


import java.util.Date;

/**
 * Credit repository.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {

  Mono<Long> countByClientIdAndPaymentDueDateLessThan(String clientId, String paymentDueDate);

  Mono<Credit> findByCardNumber(String cardNumber);

}
