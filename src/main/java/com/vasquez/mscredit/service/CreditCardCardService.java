package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.CreditCard;
import com.vasquez.mscredit.repository.CreditCardRepository;
import com.vasquez.mscredit.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardCardService implements CrudUtil<CreditCard, String> {

    private final CreditCardRepository creditCardRepository;

    public CreditCardCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Mono<CreditCard> create(CreditCard request) {
        return creditCardRepository.save(request);
    }

    @Override
    public Mono<CreditCard> update(CreditCard request, String id) {
        return creditCardRepository.save(request);
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
}
