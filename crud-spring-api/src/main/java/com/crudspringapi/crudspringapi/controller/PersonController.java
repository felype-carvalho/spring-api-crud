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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.crudspringapi.crudspringapi.dto.PersonDto;
import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;
import com.crudspringapi.crudspringapi.service.AddressService;
import com.crudspringapi.crudspringapi.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    // @GetMapping
    // public List<Person> getAll() {
    // return PersonRepository.findAll();
    // }

    // @GetMapping
    // @ResponseBody
    // @ResponseStatus(HttpStatus.OK)
    // public List<PersonDto> getPersons() {
    //     return personService.listAll();
    // }

    // @GetMapping("/{personId}")
    // public Person getById(@PathVariable Long id) {
    // return personRepository.findById(id).orElse(null);
    // }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void create(@RequestBody Person person) throws BadRequestException {
    //     personService.create(person);
    // }

    // @PutMapping("/{personId}/update")
    // public Person update(@PathVariable Long id, @RequestBody Person person) {
    // Person existingPerson = personRepository.findById(id).orElse(null);
    // if (existingPerson != null) {
    // person.setId(id);
    // return personRepository.save(person);
    // } else {
    // return null;
    // }
    // }

    // @DeleteMapping("/{personId}/delete")
    // public void delete(@PathVariable Long id) {
    // personRepository.deleteById(id);
    // }
}