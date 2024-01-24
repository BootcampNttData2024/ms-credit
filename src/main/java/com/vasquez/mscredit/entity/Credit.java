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
@Document(collection = "credit")
public class Credit {

    @Id
    private String creditId;

    @NotNull
    private String clientTypeId;

    @NotNull
    private String cardNumber;

    private Double amountRequested;

    @NotNull
    private String installmentTerm;

    @NotNull
    private Double monthlyFee;

    private LocalDate requestedDate;

}
