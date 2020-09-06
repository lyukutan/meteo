package com.example.country.controller;

import com.example.country.client.countryinfo.CountryInfoServiceClient;
import com.example.country.domain.Person;
import com.example.country.services.searchPerson.SearchFioService;
import com.example.country.services.searchPerson.SearchIdentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SuggestionController {

    @Autowired
    private CountryInfoServiceClient countryInfoServiceClient;

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String suggestions(@RequestParam("searchstr") String searchstr) {
        Person person = searchstr.matches("[-+]?\\d+")  ? new SearchIdentService().search(searchstr)  : new SearchFioService().search(searchstr);
        return countryInfoServiceClient.getCountryNameByISOCode(person.getCountry()).getCountryNameResult();
    }

}
