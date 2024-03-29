package com.vasquez.mscredit.entity;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Credit Card entity.
 *
 * @author Vasquez
 * @version 1.0.
 */
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

  private String expirationDate;

}
