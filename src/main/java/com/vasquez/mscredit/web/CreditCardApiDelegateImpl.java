package com.vasquez.mscredit.web;

import com.vasquez.mscredit.api.CreditCardApiDelegate;
import com.vasquez.mscredit.model.CreditCardRequest;
import com.vasquez.mscredit.model.CreditCardResponse;
import com.vasquez.mscredit.service.CreditCardService;
import com.vasquez.mscredit.web.mapper.CreditCardMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CreditCardApiDelegateImpl.java
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class CreditCardApiDelegateImpl implements CreditCardApiDelegate {

  private final CreditCardService creditCardService;

  public CreditCardApiDelegateImpl(CreditCardService creditCardService) {
    this.creditCardService = creditCardService;
  }

  @Override
  public Mono<ResponseEntity<CreditCardResponse>> addCreditCard(Mono<CreditCardRequest> creditCardRequest, ServerWebExchange exchange) {
    return creditCardRequest
      .map(CreditCardMapper::toEntity)
      .flatMap(creditCardService::create)
      .map(CreditCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> deleteCreditCardById(String creditCardId, ServerWebExchange exchange) {
    return creditCardService.deleteById(creditCardId)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<CreditCardResponse>>> getAllCreditCard(ServerWebExchange exchange) {
    return Mono.just(creditCardService.findAll()
        .map(CreditCardMapper::toResponse))
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<CreditCardResponse>> getCreditCardById(String creditCardId, ServerWebExchange exchange) {
    return creditCardService.findById(creditCardId)
      .map(CreditCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<CreditCardResponse>> updateCreditCard(String creditCardId, Mono<CreditCardRequest> creditCardRequest, ServerWebExchange exchange) {
    return creditCardRequest
      .map(CreditCardMapper::toEntity)
      .flatMap(cre -> creditCardService.update(cre, creditCardId))
      .map(CreditCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Integer>> countByClientId(String clientId, ServerWebExchange exchange) {
    return creditCardService.countByClientId(clientId)
      .map(res -> ResponseEntity.ok(Integer.parseInt(res.toString())));
  }
}
