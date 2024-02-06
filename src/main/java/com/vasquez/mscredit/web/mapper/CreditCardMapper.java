package com.vasquez.mscredit.web.mapper;

import com.vasquez.mscredit.entity.CreditCard;
import com.vasquez.mscredit.model.CreditCardRequest;
import com.vasquez.mscredit.model.CreditCardResponse;
import org.springframework.beans.BeanUtils;

/**
 * Credit card mapper class.
 *
 * @author Vasquez
 * @version 1.0.
 */
public class CreditCardMapper {

  /**
   * To entity.
   *
   * @param creditCardRequest credit card request
   * @return Credit Card entity
   */
  public static CreditCard toEntity(CreditCardRequest creditCardRequest) {
    CreditCard creditCard = new CreditCard();
    BeanUtils.copyProperties(creditCardRequest, creditCard);
    return creditCard;
  }

  /**
   * To response.
   *
   * @param creditCard credit card
   * @return Credit Card response
   */
  public static CreditCardResponse toResponse(CreditCard creditCard) {
    CreditCardResponse creditCardResponse = new CreditCardResponse();
    BeanUtils.copyProperties(creditCard, creditCardResponse);
    return creditCardResponse;
  }

}
