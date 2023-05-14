package com.crudspringapi.crudspringapi.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.exceptionhandler.ResourceNotFoundException;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons(String name) {
        List<Person> persons = new ArrayList<Person>();

        if (name == null) {
            personRepository.findAll().forEach(persons::add);
        } else {
            personRepository.findByName(name).forEach(persons::add);
        }

        return persons;
    }

    public Person getPersonById(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return person;
    }

    public Person createPerson(Person person) {
        personVerification(person);

        Person _person = personRepository.save(
                new Person(person.getId(), person.getName(), person.getEmail(), person.getCpf()));

        return _person;
    }

    public Person updaPerson(long id,Person person) {
        personVerification(person);

        Person _person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Person with id = " + id));

        _person.setName(person.getName());
        _person.setEmail(person.getEmail());
        _person.setCpf(person.getCpf());

        return _person;
    }

    public void deletePerson (long id) {
        personRepository.deleteById(id);
    }

    public void deleteAllPersons () {
        personRepository.deleteAll();
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

}
