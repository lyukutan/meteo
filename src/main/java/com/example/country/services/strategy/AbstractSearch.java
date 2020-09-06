package com.example.country.services.strategy;

import com.example.country.domain.Person;
import com.example.country.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractSearch {
    @Autowired
    protected PersonRepository personRepository;

    public List<Person> searchAll() {
        return personRepository.findAll();
    }
}
