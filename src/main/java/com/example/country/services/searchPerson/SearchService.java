package com.example.country.services.searchPerson;

import com.example.country.domain.Person;
import com.example.country.services.strategy.SearchStrategy;

import java.util.List;

public class SearchService {
    SearchStrategy searchStrategy;

    public Person search(String searchString) {
        return searchStrategy.search(searchString);
    }
}
