package com.example.country.controller;

import com.example.country.domain.Person;
import com.example.country.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String showIndex(Model model) {
        List<Person> personList = personRepository.findAll();

        model.addAttribute("personList", personList);

        return "index";
    }
}