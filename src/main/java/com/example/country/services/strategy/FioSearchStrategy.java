package com.example.country.services.strategy;

import com.example.country.domain.Person;
import com.example.country.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FioSearchStrategy extends AbstractSearch implements SearchStrategy{

    @Override
    public Person search(String searchString) {
        return personRepository.findAll()
                .stream()
                .filter(s -> s.getFio().toLowerCase().equals(searchString.toLowerCase()))
                .findFirst().orElse(null);
    }
}
