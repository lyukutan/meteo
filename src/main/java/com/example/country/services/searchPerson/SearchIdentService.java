package com.example.country.services.searchPerson;

import com.example.country.services.strategy.IdentSearchStrategy;

public class SearchIdentService extends SearchService {

    public SearchIdentService() {
        this.searchStrategy = new IdentSearchStrategy();
    }

}
