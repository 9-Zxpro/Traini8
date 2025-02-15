package com.example.Traini8.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class TrainingCenterRequest {

    @NotBlank(message = "Center name is mandatory")
    @Size(max = 39, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric character")
    private String centerCode;

    @Valid
    @NotNull(message = "Address is mandatory")
    private AddressRequest address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    @Email(message = "Contact email must be valid")
    private String contactEmail;

    @NotBlank(message = "Contact phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact phone is invalid")
    private String contactPhone;

}
