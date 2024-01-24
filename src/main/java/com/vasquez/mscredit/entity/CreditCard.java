package com.vasquez.mscredit.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_card")
public class CreditCard {

    @Id
    private String creditCardId;

    @NotNull
    private String productId;

    @NotNull
    private String clientId;

    private String cardNumber;

    @NotNull
    private Double availableAmount;

    @NotNull
    private Double creditLimit;

    private LocalDate expirationDate;

}
