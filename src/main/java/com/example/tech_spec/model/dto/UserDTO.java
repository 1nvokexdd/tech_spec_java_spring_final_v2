package com.example.tech_spec.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
   @NotBlank(message = "this column not be empty")
    @Size(max = 50 , message = "max length for name 50 ")
     private String name;


    @NotBlank(message = "this column not be empty")

    @Size(max = 150 , message = "max length for email 50 ")
    private String email;
}
