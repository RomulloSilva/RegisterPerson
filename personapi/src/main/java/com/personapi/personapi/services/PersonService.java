package com.personapi.personapi.services;

import com.personapi.personapi.domain.interfaces.PersonValidation;
import com.personapi.personapi.dto.PersonDTO;
import com.personapi.personapi.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonValidation personValidation;


    public Boolean savePerson(PersonDTO personDTO) {
        return personValidation.savePerson(personDTO);
    }

    public PersonEntity findPersonById(Integer personId) {
        return personValidation.findPersonById(personId);
    }

    public Boolean deletePerson(Integer personId) {
        return personValidation.deletePersonById(personId);
    }
}
