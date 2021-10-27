package com.personapi.personapi.entities;

import com.personapi.personapi.dto.PersonDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = -4504515003337672622L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastname;

    @Column(name = "cpf", length = 50, nullable = false, unique = true)
    private String cpf;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;


    public static PersonEntity of(PersonDTO personDTO) {
        return PersonEntity.builder()
                .firstName(personDTO.getFirstName())
                .lastname(personDTO.getLastname())
                .cpf(personDTO.getCpf())
                .birthDate(personDTO.getBirthDate())
                .build();
    }

}
