package com.crudspringapi.crudspringapi.service;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;


@SpringBootTest
@AutoConfigureMockMvc
class PersonServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonRepository personRepository;

    @MockBean
    PersonService personService;

    @Test
    void getAllPersons_WithPerson_Success() {
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName("Robson");
        p1.setEmail("robson@gmail.com");
        p1.setCpf("11122233344");
        
        persons.add(p1);

        Mockito.when(personService.getAllPersons(null)).thenReturn(persons);
        
        List<Person> personsTest = personService.getAllPersons(null);

        Assertions.assertNotNull(personsTest);
        Assertions.assertEquals(persons, personsTest);
    }

    @Test
    void getAllPersons_WithPerson_Error() {
        List<Person> persons = new ArrayList<Person>();        

        Mockito.when(personService.getAllPersons(null)).thenReturn(persons);
        
        List<Person> personsTest = personService.getAllPersons(null);

        Assertions.assertTrue(personsTest.isEmpty());
        Assertions.assertEquals(persons, personsTest);
    }

    @Test
    void getAllPersons_WithName_Success() {
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName("Robson");
        p1.setEmail("robson@gmail.com");
        p1.setCpf("11122233344");
        
        persons.add(p1);

        Mockito.when(personService.getAllPersons("Robson")).thenReturn(persons);
        
        List<Person> personsTest = personService.getAllPersons("Robson");

        Assertions.assertNotNull(personsTest);
        Assertions.assertEquals(persons, personsTest);
    }

    @Test
    void getPersonById_Success() {
        Person person = new Person();
        person.setName("Robson");
        person.setEmail("robson@gmail.com");
        person.setCpf("11122233344");

        Mockito.when(personService.getPersonById(1)).thenReturn(person);

        Person personTest = personService.getPersonById(1);

        Assertions.assertNotNull(personTest);
        Assertions.assertEquals(person.getCpf(), personTest.getCpf());
        Assertions.assertEquals(person.getName(), personTest.getName());
        Assertions.assertEquals(person.getEmail(), personTest.getEmail());
        Assertions.assertEquals(person, personTest);
    }

    @Test
    void getPersonById_Error()  {

        Mockito.when(personService.getPersonById(1)).thenReturn(null);

        Person personTest = personService.getPersonById(1);

        Assertions.assertNull(personTest);
    }

    @Test
    void createPerson_Success() {
        Person person = new Person();
        person.setName("Robson");
        person.setEmail("robson@gmail.com");
        person.setCpf("11122233344");

        Mockito.when(personService.createPerson(person)).thenReturn(person);

        Person personTest = personService.createPerson(person);

        Assertions.assertNotNull(personTest);
        Assertions.assertEquals(person.getCpf(), personTest.getCpf());
        Assertions.assertEquals(person.getName(), personTest.getName());
        Assertions.assertEquals(person.getEmail(), personTest.getEmail());
        Assertions.assertEquals(person, personTest);
    }




}