package com.example.tech_spec.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.tech_spec.model.SubscriptionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDTO {
  @NotNull(message = "this column not be empty")
      private SubscriptionType subscriptionType;
      @NotNull(message = "this column not be empty")
    private LocalDate startDate;
  @NotNull(message = "this column not be empty")
    private LocalDate endDate;
   @NotNull(message = "this column not be empty")
    private BigDecimal monthlyPrice;
}
