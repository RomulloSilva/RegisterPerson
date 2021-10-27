package com.personapi.personapi.dto;

import com.personapi.personapi.config.validator.SafeTextValidator;
import com.personapi.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO implements Serializable {


    private static final long serialVersionUID = -1713411800343959208L;
    @NotNull(message = "User id cannot be null")
    private Integer userId;

    @NotBlank(message = "Type of phone cannot be blank")
    @NotNull(message = "Type of phone cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private PhoneType type;

    @NotBlank(message = "Phone cannot be blank")
    @NotNull(message = "Phone cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", flags = Pattern.Flag.UNICODE_CASE, message = "Invalid phone number.")
    private String number;

    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid email.")
    private String email;
}
