package com.vasquez.mscredit.service.impl;

import com.vasquez.mscredit.entity.DebitCard;
import com.vasquez.mscredit.repository.DebitCardRepository;
import com.vasquez.mscredit.service.DebitCardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Debit card service implementation.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Log4j2
@Service
public class DebitCardServiceImpl implements DebitCardService {

  private final DebitCardRepository debitCardRepository;

  public DebitCardServiceImpl(DebitCardRepository debitCardRepository) {
    this.debitCardRepository = debitCardRepository;
  }

  @Override
  public Mono<DebitCard> create(DebitCard request) {
    log.info("Creating a new debit card, {}", request);
    request.setAvailableAmount(0.0);
    return debitCardRepository.save(request);
  }

  @Override
  public Mono<DebitCard> update(DebitCard request, String id) {
    return this.findById(id).flatMap(creditCard -> {
      creditCard.setAvailableAmount(request.getAvailableAmount());
      return debitCardRepository.save(creditCard);
    });
  }

  @Override
  public Mono<DebitCard> findById(String id) {
    return debitCardRepository.findById(id);
  }

  @Override
  public Flux<DebitCard> findAll() {
    return debitCardRepository.findAll();
  }

}
