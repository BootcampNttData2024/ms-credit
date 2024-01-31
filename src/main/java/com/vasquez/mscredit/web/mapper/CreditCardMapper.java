package com.vasquez.mscredit.web.mapper;

import com.vasquez.mscredit.entity.CreditCard;
import com.vasquez.mscredit.model.CreditCardRequest;
import com.vasquez.mscredit.model.CreditCardResponse;

import org.springframework.beans.BeanUtils;

public class CreditCardMapper {

    public static CreditCard toEntity(CreditCardRequest CreditCardRequest) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(CreditCardRequest, creditCard);
        return creditCard;
    }

    public static CreditCardResponse toResponse(CreditCard CreditCard) {
        CreditCardResponse creditCardResponse = new CreditCardResponse();
        BeanUtils.copyProperties(CreditCard, creditCardResponse);
        return creditCardResponse;
    }

}
