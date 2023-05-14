package com.crudspringapi.crudspringapi.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crudspringapi.crudspringapi.dto.PersonDto;
import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.exceptionhandler.NotFoundException;
import com.crudspringapi.crudspringapi.exceptionhandler.ResourceNotFoundException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;
import com.crudspringapi.crudspringapi.service.AddressService;
import com.crudspringapi.crudspringapi.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

    // @Autowired
    // private PersonService personService;

    @Autowired
    PersonRepository personRepository;

    // @Autowired
    // private AddressService addressService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String name) {
        List<Person> persons = new ArrayList<Person>();

        if (name == null) {
            personRepository.findAll().forEach(persons::add);
        } else {
            personRepository.findByName(name).forEach(persons::add);
        }

        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createTutorial(@RequestBody Person person) {
        personVerification(person);

        Person _person = personRepository.save(
                new Person(person.getId(), person.getName(), person.getEmail(), person.getCpf()));
        return new ResponseEntity<>(_person, HttpStatus.CREATED);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        personVerification(person);

        Person _person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Person with id = " + id));

        _person.setName(person.getName());
        _person.setEmail(person.getEmail());
        _person.setCpf(person.getCpf());

        return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
    }

    private void personVerification(Person person) throws BadRequestException {
        List<Person> listPerson = new ArrayList<>();

        personRepository.findByCpf(person.getCpf()).forEach(listPerson::add);
        if (!listPerson.isEmpty()) {
            throw new BadRequestException("CPF is already in use!");
        }

        personRepository.findByEmail(person.getEmail()).forEach(listPerson::add);
        if (!listPerson.isEmpty()) {
            throw new BadRequestException("Email is already in use!");
        }

    }

    // @GetMapping
    // @ResponseBody
    // @ResponseStatus(HttpStatus.OK)
    // public List<PersonDto> getPersons() {
    // return personService.listAll();
    // }

    // @GetMapping("/{personId}")
    // public Person getById(@PathVariable Long id) {
    // return personRepository.findById(id).orElse(null);
    // }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void create(@RequestBody Person person) throws BadRequestException {
    // personService.create(person);
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