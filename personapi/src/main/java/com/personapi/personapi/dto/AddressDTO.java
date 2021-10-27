package com.personapi.personapi.dto;

import com.personapi.personapi.config.validator.SafeTextValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {


    private static final long serialVersionUID = -6842849764410190115L;

    @NotNull(message = "User id cannot be null")
    private Integer userId;

    @NotBlank(message = "Public place  cannot be blank")
    @NotNull(message = "Public place cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String publicPlace;

    @NotBlank(message = "Zipcode cannot be blank")
    @NotNull(message = "Zipcode cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String zipCode;

    @NotBlank(message = "City cannot be blank")
    @NotNull(message = "City cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @NotNull(message = "State cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    @NotNull(message = "Country cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String country;
}
