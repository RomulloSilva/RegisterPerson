package com.personapi.personapi.domain.impl;

import com.personapi.personapi.domain.interfaces.PersonValidation;
import com.personapi.personapi.dto.PersonDTO;
import com.personapi.personapi.entities.PersonEntity;
import com.personapi.personapi.exception.PersonException;
import com.personapi.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@AllArgsConstructor
public class PersonValidationImpl implements PersonValidation {

    private final PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean savePerson(PersonDTO personDTO) {
        try {
            personRepository.save(PersonEntity.of(personDTO));
            return true;
        } catch (Exception exception) {
            throw new PersonException("Failed to save person" + exception);
        }
    }


    @Override
    public PersonEntity findPersonById(Integer personId) {
        try {
            return personRepository.findById(personId).orElse(null);
        } catch (Exception exception) {
            throw new PersonException("Failed to find person" + exception);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deletePersonById(Integer personId) {
        try {
            personRepository.deleteById(personId);
            return true;
        } catch (Exception exception) {
            throw new PersonException("Failed to delete person" + exception);
        }
    }

}
