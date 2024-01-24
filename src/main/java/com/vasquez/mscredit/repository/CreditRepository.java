package com.vasquez.mscredit.repository;

import com.vasquez.mscredit.entity.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
}
