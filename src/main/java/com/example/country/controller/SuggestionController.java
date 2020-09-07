package com.example.country.controller;

import com.example.country.client.countryinfo.CountryInfoServiceClient;
import com.example.country.domain.Person;
import com.example.country.services.searchPerson.SearchFioService;
import com.example.country.services.searchPerson.SearchIdentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suggestion")
public class SuggestionController {

    @Autowired
    private CountryInfoServiceClient countryInfoServiceClient;

    @PostMapping
    public String suggestions(@RequestBody String searchstr) {
        Person person = searchstr.matches("[-+]?\\d+")  ? new SearchIdentService().search(searchstr)  : new SearchFioService().search(searchstr);
        return countryInfoServiceClient.getCountryNameByISOCode(person.getCountry()).getCountryNameResult();
    }

}
