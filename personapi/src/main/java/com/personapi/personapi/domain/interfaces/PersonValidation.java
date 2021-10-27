package com.personapi.personapi.domain.interfaces;

import com.personapi.personapi.dto.PersonDTO;
import com.personapi.personapi.entities.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public interface PersonValidation {


    boolean savePerson(PersonDTO personDTO);

    PersonEntity findPersonById(Integer personId);

    Boolean deletePersonById(Integer personId);
}
