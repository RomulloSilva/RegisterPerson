package com.personapi.personapi.entities;


import com.personapi.personapi.dto.AddressDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = -5658749536007034617L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "person_id", nullable = false)
    private Integer userId;

    @Column(name = "public_place", length = 80, nullable = false)
    private String publicPlace;

    @Column(name = "zip_code", length = 80, nullable = false)
    private String zipCode;

    @Column(name = "city", length = 80, nullable = false)
    private String city;

    @Column(name = "state_name", length = 80, nullable = false)
    private String state;

    @Column(name = "country", length = 80, nullable = false)
    private String country;

    private static AddressEntity of(AddressDTO addressDTO) {
        return AddressEntity.builder()
                .userId(addressDTO.getUserId())
                .publicPlace(addressDTO.getPublicPlace())
                .zipCode(addressDTO.getZipCode())
                .city(addressDTO.getCity())
                .state(addressDTO.getState())
                .country(addressDTO.getCountry())
                .build();
    }

}
