package com.vasquez.mscredit.repository;

import com.vasquez.mscredit.entity.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard, String> {
}
