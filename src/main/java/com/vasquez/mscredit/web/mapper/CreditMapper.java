package com.vasquez.mscredit.web.mapper;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.model.CreditRequest;
import com.vasquez.mscredit.model.CreditResponse;
import org.springframework.beans.BeanUtils;

/**
 * Credit mapper class.
 *
 * @author Vasquez
 * @version 1.0.
 */
public class CreditMapper {

  /**
   * To entity.
   *
   * @param creditRequest credit request
   * @return Credit entity
   */
  public static Credit toEntity(CreditRequest creditRequest) {
    Credit credit = new Credit();
    BeanUtils.copyProperties(creditRequest, credit);
    return credit;
  }

  /**
   * To response.
   *
   * @param credit credit
   * @return Credit response
   */
  public static CreditResponse toResponse(Credit credit) {
    CreditResponse creditResponse = new CreditResponse();
    BeanUtils.copyProperties(credit, creditResponse);
    return creditResponse;
  }

}
