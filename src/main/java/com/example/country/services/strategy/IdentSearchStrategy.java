package com.example.country.services.strategy;

import com.example.country.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class IdentSearchStrategy extends AbstractSearch implements SearchStrategy {

    @Override
    public Person search(String searchString) {
        return personRepository.findAll()
                .stream()
                .filter(s -> s.getIdent().toLowerCase().equals(searchString.toLowerCase()))
                .findFirst().orElse(null);
    }
}
