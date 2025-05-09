package com.example.tech_spec.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.tech_spec.model.SubscriptionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDTO {
  @NotBlank(message = "this column not be empty")
      private SubscriptionType subscriptionType;
      @NotBlank(message = "this column not be empty")
    private LocalDate startDate;
   @NotBlank(message = "this column not be empty")
    private LocalDate endDate;
   @NotBlank(message = "this column not be empty")
    private BigDecimal monthlyPrice;
}
