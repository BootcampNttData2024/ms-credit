package com.vasquez.mscredit.web.mapper;

import com.vasquez.mscredit.entity.Credit;
import com.vasquez.mscredit.model.CreditRequest;
import com.vasquez.mscredit.model.CreditResponse;
import org.springframework.beans.BeanUtils;

public class CreditMapper {

    public static Credit toEntity(CreditRequest CreditRequest) {
        Credit credit = new Credit();
        BeanUtils.copyProperties(CreditRequest, credit);
        return credit;
    }

    public static CreditResponse toResponse(Credit Credit) {
        CreditResponse creditResponse = new CreditResponse();
        BeanUtils.copyProperties(Credit, creditResponse);
        return creditResponse;
    }

}
