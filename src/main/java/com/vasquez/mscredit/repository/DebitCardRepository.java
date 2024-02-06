package com.vasquez.mscredit.repository;

import com.vasquez.mscredit.entity.DebitCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Debit Card repository.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Repository
public interface DebitCardRepository extends ReactiveMongoRepository<DebitCard, String> {

}
