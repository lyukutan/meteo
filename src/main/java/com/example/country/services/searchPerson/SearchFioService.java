package com.example.country.services.searchPerson;

import com.example.country.services.strategy.FioSearchStrategy;

public class SearchFioService extends SearchService {

    public SearchFioService() {
        this.searchStrategy = new FioSearchStrategy();
    }
}
