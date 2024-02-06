package com.vasquez.mscredit.web;

import com.vasquez.mscredit.api.DebitCardApiDelegate;
import com.vasquez.mscredit.model.DebitCardRequest;
import com.vasquez.mscredit.model.DebitCardResponse;
import com.vasquez.mscredit.service.DebitCardService;
import com.vasquez.mscredit.web.mapper.DebitCardMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * DebitCardApiDelegateImpl.java
 *
 * @author Vasquez
 * @version 1.0.0
 */
@Service
public class DebitCardApiDelegateImpl implements DebitCardApiDelegate {

  private final DebitCardService debitCardService;

  public DebitCardApiDelegateImpl(DebitCardService debitCardService) {
    this.debitCardService = debitCardService;
  }

  @Override
  public Mono<ResponseEntity<DebitCardResponse>> addDebitCard(Mono<DebitCardRequest> debitCardRequest, ServerWebExchange exchange) {
    return debitCardRequest
      .map(DebitCardMapper::toEntity)
      .flatMap(debitCardService::create)
      .map(DebitCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Flux<DebitCardResponse>>> getAllDebitCard(ServerWebExchange exchange) {
    return Mono.just(debitCardService.findAll()
        .map(DebitCardMapper::toResponse))
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<DebitCardResponse>> getDebitCardById(String debitCardId, ServerWebExchange exchange) {
    return debitCardService.findById(debitCardId)
      .map(DebitCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<DebitCardResponse>> updateDebitCard(String debitCardId, Mono<DebitCardRequest> debitCardRequest, ServerWebExchange exchange) {
    return debitCardRequest
      .map(DebitCardMapper::toEntity)
      .flatMap(cre -> debitCardService.update(cre, debitCardId))
      .map(DebitCardMapper::toResponse)
      .map(ResponseEntity::ok);
  }

}
