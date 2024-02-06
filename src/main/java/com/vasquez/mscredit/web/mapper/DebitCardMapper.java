package com.vasquez.mscredit.web.mapper;

import com.vasquez.mscredit.entity.DebitCard;
import com.vasquez.mscredit.model.DebitCardRequest;
import com.vasquez.mscredit.model.DebitCardResponse;
import org.springframework.beans.BeanUtils;

/**
 * Debit card mapper class.
 *
 * @author Vasquez
 * @version 1.0.
 */
public class DebitCardMapper {

  /**
   * To entity.
   *
   * @param debitCardRequest debit card request
   * @return Debit Card entity
   */
  public static DebitCard toEntity(DebitCardRequest debitCardRequest) {
    DebitCard debitCard = new DebitCard();
    BeanUtils.copyProperties(debitCardRequest, debitCard);
    return debitCard;
  }

  /**
   * To response.
   *
   * @param debitCard debit card
   * @return Debit Card response
   */
  public static DebitCardResponse toResponse(DebitCard debitCard) {
    DebitCardResponse debitCardResponse = new DebitCardResponse();
    BeanUtils.copyProperties(debitCard, debitCardResponse);
    return debitCardResponse;
  }

}
