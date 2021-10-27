package com.personapi.personapi.entities;

import com.personapi.personapi.dto.ContactDTO;
import com.personapi.personapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "person_id", nullable = false)
    private Integer userId;

    @Column(name = "phone_type", length = 50, nullable = false)
    private PhoneType type;

    @Column(name = "phone_number", length = 50, nullable = false)
    private String number;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    public static ContactEntity of(ContactDTO contactDTO) {
        return ContactEntity.builder()
                .userId(contactDTO.getUserId())
                .type(contactDTO.getType())
                .number(contactDTO.getNumber())
                .email(contactDTO.getEmail())
                .build();
    }
}
