package com.crudspringapi.crudspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;
import com.crudspringapi.crudspringapi.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String name) {
        List<Person> persons = personService.getAllPersons(name);

        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        Person person = personService.getPersonById(id);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person _person = personService.createPerson(person);
        
        return new ResponseEntity<>(_person, HttpStatus.CREATED);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        Person _person = personService.updaPerson(id, person);

        return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        personService.deleteAllPersons();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}