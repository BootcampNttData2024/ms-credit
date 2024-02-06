package com.vasquez.mscredit.service.impl;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.repository.CreditRepository;
import com.vasquez.mscredit.service.CreditService;
import com.vasquez.mscredit.service.exception.AppException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Credit service implementation.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Log4j2
@Service
public class CreditServiceImpl implements CreditService {

  private final CreditRepository creditRepository;

  public CreditServiceImpl(CreditRepository creditRepository) {
    this.creditRepository = creditRepository;
  }

  @Override
  public Mono<Credit> create(Credit request) {
    Double monthlyFee = request.getAmountRequested() / request.getMaxMonthsOfPayment();
    String dueDate = LocalDateTime.now().plusMonths(request.getMaxMonthsOfPayment()).toString();
    request.setMonthlyFee(monthlyFee);
    request.setPaymentDueDate(dueDate);
    request.setAmountPaid(0.0);
    request.setDebtAmount(request.getAmountRequested());
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
    log.info("CreditServiceImpl.findAll()");
    return creditRepository.findAll();
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return creditRepository.deleteById(id);
  }

  @Override
  public Mono<Long> countByClientIdAndPaymentDueDateLessThan(String clientId) {
    log.info("CreditServiceImpl.countByClientIdAndPaymentDueDateLessThan()");
    return creditRepository.countByClientIdAndPaymentDueDateLessThan(clientId, String.valueOf(LocalDateTime.now()));
  }

  @Override
  public Mono<Credit> findByCardNumber(String cardNumber) {
    log.info("CreditServiceImpl.findByCardNumber, {}", cardNumber);
    return creditRepository.findByCardNumber(cardNumber);
  }

  @Override
  public Mono<Credit> modifyCreditByCardNumber(Credit request, String cardNumber) {
    log.info("CreditServiceImpl.modifyCreditByCardNumber, {}", request);
    return creditRepository.findByCardNumber(cardNumber)
      .switchIfEmpty(Mono.error(AppException.notFound("The accountsProxy.findByCardNumber not found.")))
      .flatMap(credit -> {
        log.info("credit, {}", credit);
        credit.setAmountPaid(credit.getAmountPaid() + request.getAmountPaid());
        credit.setDebtAmount(credit.getAmountRequested() - credit.getAmountPaid());
        return creditRepository.save(credit);
      });
  }
}
