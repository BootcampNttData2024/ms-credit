package com.vasquez.mscredit.web;

import com.vasquez.mscredit.api.CreditApiDelegate;
import com.vasquez.mscredit.model.CreditRequest;
import com.vasquez.mscredit.model.CreditResponse;
import com.vasquez.mscredit.service.CreditService;
import com.vasquez.mscredit.web.mapper.CreditMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CreditApiDelegateImpl.java
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class CreditApiDelegateImpl implements CreditApiDelegate {

  private final CreditService creditService;

  public CreditApiDelegateImpl(CreditService creditService) {
    this.creditService = creditService;
  }

  @Override
  public Mono<ResponseEntity<CreditResponse>> addCredit(Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
    return creditRequest
      .map(CreditMapper::toEntity)
      .flatMap(creditService::create)
      .map(CreditMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteCreditById(String creditId, ServerWebExchange exchange) {
    return creditService.deleteById(creditId)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<CreditResponse>>> getAllCredits(ServerWebExchange exchange) {
    return Mono.just(ResponseEntity.ok(creditService.findAll()
      .map(CreditMapper::toResponse)));
  }

  @Override
  public Mono<ResponseEntity<CreditResponse>> getCreditById(String creditId, ServerWebExchange exchange) {
    return creditService.findById(creditId)
      .map(CreditMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<CreditResponse>> updateCredit(String creditId, Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
    return creditRequest
      .map(CreditMapper::toEntity)
      .flatMap(cre -> creditService.update(cre, creditId))
      .map(CreditMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Integer>> countByClientIdAndPaymentDueDate(String clientId, ServerWebExchange exchange) {
    return creditService.countByClientIdAndPaymentDueDateLessThan(clientId)
      .map(res -> ResponseEntity.ok(Integer.parseInt(res.toString())));
  }

  @Override
  public Mono<ResponseEntity<CreditResponse>> modifyCredit(String cardNumber, Mono<CreditRequest> creditRequest, ServerWebExchange exchange) {
    return creditRequest
      .map(CreditMapper::toEntity)
      .flatMap(cre -> creditService.modifyCreditByCardNumber(cre, cardNumber))
      .map(CreditMapper::toResponse)
      .map(ResponseEntity::ok);
  }
}
