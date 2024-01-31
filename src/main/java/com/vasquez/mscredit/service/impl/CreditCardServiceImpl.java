package com.vasquez.mscredit.service.impl;

import com.vasquez.mscredit.entity.CreditCard;
import com.vasquez.mscredit.repository.CreditCardRepository;
import com.vasquez.mscredit.service.CreditCardService;
import com.vasquez.mscredit.service.CreditService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Mono<CreditCard> create(CreditCard request) {
        return creditCardRepository.save(request);
    }

    @Override
    public Mono<CreditCard> update(CreditCard request, String id) {
        return this.findById(id).flatMap(creditCard -> {
            creditCard.setAvailableAmount(request.getAvailableAmount());
            creditCard.setCreditLimit(request.getCreditLimit());
            return creditCardRepository.save(creditCard);
        });
    }

    @Override
    public Mono<CreditCard> findById(String id) {
        return creditCardRepository.findById(id);
    }

    @Override
    public Flux<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return creditCardRepository.deleteById(id);
    }

    public Mono<Integer> countByClientId(String clientId) {
        return creditCardRepository.countByClientId(clientId);
    }
}
