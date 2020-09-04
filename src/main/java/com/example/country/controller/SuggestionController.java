package com.example.country.controller;

import com.example.country.domain.Person;
import com.example.country.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SuggestionController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Person> autocompleteSuggestions(@RequestParam("searchstr") String searchstr) {
        return personRepository.findAll()
                .stream()
                .filter(s -> s.getFio().toLowerCase().contains(searchstr.toLowerCase()))
                .collect(Collectors.toList());
    }

}
