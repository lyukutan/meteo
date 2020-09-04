package com.example.country.controller;

import com.example.country.domain.Person;
import com.example.country.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @GetMapping("{id}")
    public Person getOne(@PathVariable("id") Person person) {
        return person;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("{id}")
    public Person update(
            @PathVariable("id") Person personFromDb,
            @RequestBody Person person
    ) {
        BeanUtils.copyProperties(person, personFromDb, "id");

        return personRepository.save(personFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Person person) {
        personRepository.delete(person);
    }
}