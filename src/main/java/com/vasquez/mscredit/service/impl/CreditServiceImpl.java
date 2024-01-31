package com.vasquez.mscredit.service.impl;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.repository.CreditRepository;
import com.vasquez.mscredit.service.CreditService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Mono<Credit> create(Credit request) {
        Double monthlyFee = request.getAmountRequested() / request.getMaxMonthsOfPayment();
        request.setMonthlyFee(monthlyFee);
        return creditRepository.save(request);
    }

    @Override
    public Mono<Credit> update(Credit request, String id) {
        return this.findById(id).flatMap(credit -> {
            credit.setCardNumber(request.getCardNumber());
            credit.setAmountRequested(request.getAmountRequested());
            credit.setMaxMonthsOfPayment(request.getMaxMonthsOfPayment());
            return creditRepository.save(credit);
        });
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
