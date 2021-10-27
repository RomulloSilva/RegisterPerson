package com.personapi.personapi.dto;

import com.personapi.personapi.config.validator.SafeTextValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {


    private static final long serialVersionUID = -7646702630845625728L;

   /*
    @SafeTextValidator(message = "Improper xss script detected.")
    private Integer id;
    */

    @NotBlank(message = "User's first name cannot be blank")
    @NotNull(message = "User's first name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String firstName;


    @NotBlank(message = "User's last name cannot be blank")
    @NotNull(message = "User's last name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String lastname;

    @NotBlank(message = "CPF cannot be blank")
    @NotNull(message = "CPF cannot be null")
    @CPF
    @SafeTextValidator(message = "Improper xss script detected.")
    private String cpf;

    @Past(message = "Invalid birth date.")
    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;
}
