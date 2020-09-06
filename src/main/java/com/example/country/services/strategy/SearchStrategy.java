package com.example.country.services.strategy;

import com.example.country.domain.Person;

import java.util.List;

public interface SearchStrategy {

    public Person search(String searchString);
}
