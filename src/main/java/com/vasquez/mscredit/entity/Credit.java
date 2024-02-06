package com.vasquez.mscredit.entity;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Credit entity.
 *
 * @author Vasquez
 * @version 1.0.
 */
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
  private String clientId;

  @NotNull
  private String productId;

  @NotNull
  private String cardNumber;

  private Double amountRequested;

  private Double amountPaid;

  private Double debtAmount;

  @NotNull
  private Integer maxMonthsOfPayment;

  @NotNull
  private Double monthlyFee;

  private String requestedDate = LocalDateTime.now().toString();

  private String paymentDueDate;

}
