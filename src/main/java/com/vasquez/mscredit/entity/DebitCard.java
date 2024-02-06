package com.vasquez.mscredit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * Debit Card entity.
 *
 * @author Vasquez
 * @version 1.0.
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "debit_card")
public class DebitCard {

  @Id
  private String debitCardId;

  @NotNull
  private String productId;

  @NotNull
  private String clientId;

  @NotNull
  private String cardNumber;

  @NotNull
  private Double availableAmount;

  private String expirationDate;

  private String associatedMainAccount;

  private List<String> otherAssociatedAccounts;

}
