package com.personapi.personapi.controllers;

import com.personapi.personapi.dto.Data;
import com.personapi.personapi.dto.PersonDTO;
import com.personapi.personapi.entities.PersonEntity;
import com.personapi.personapi.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    private static final String MESSAGE_FAILURE_POST = "Failure to save person.";


    @PostMapping
    public ResponseEntity<Object> insertNewUser(@RequestBody @Valid PersonDTO personDTO) {
        if (personService.savePerson(personDTO)) {
            return ResponseEntity.ok(new Data<PersonDTO>(personDTO));
        }
        return new ResponseEntity<>(MESSAGE_FAILURE_POST, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Integer personId) {
        PersonEntity personEntity;
        personEntity = personService.findPersonById(personId);
        if (nonNull(personEntity)) {
            return ResponseEntity.ok(new Data<PersonEntity>(personEntity));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Integer personId) {
        if (personService.deletePerson(personId)) {
            return ResponseEntity.ok("Person Deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
