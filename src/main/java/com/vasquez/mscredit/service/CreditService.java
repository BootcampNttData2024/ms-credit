package com.vasquez.mscredit.service;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.repository.CreditRepository;
import com.vasquez.mscredit.util.CrudUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService implements CrudUtil<Credit, String> {

    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Mono<Credit> create(Credit request) {
        return creditRepository.save(request);
    }

    @Override
    public Mono<Credit> update(Credit request, String id) {
        return creditRepository.save(request);
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return creditRepository.deleteById(id);
    }
}
