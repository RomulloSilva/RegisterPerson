package com.personapi.personapi.repositories;


import com.personapi.personapi.entities.ContactEntity;
import com.personapi.personapi.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
