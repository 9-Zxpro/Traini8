package com.example.Traini8.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank(message = "Detailed address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pincode must be six digit")
    private String pincode;

}