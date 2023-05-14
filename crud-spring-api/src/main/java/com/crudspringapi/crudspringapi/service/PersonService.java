package com.crudspringapi.crudspringapi.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringapi.crudspringapi.dto.PersonDto;
import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressService addressService;

    public Person create(Person person) throws BadRequestException {
        personVerification(person);

        List<Address> addresses = person.getAddresses();

        personRepository.save(person);
        addressService.create(addresses, person);
        return person;
    }

    public List<PersonDto> listAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> dtoList = new ArrayList<>();

        for (Person person : personList) {
            PersonDto personDto = new PersonDto();

            personDto.setId(person.getId());
            personDto.setName(person.getName());
            personDto.setEmail(person.getEmail());
            personDto.setCpf(person.getCpf());

            List <Address> addressesList = new ArrayList<>();
            addressesList = addressService.findAddressesByPersonId(person.getId());

            personDto.setAddresses(addressesList);
            
            dtoList.add(personDto);
        }

        return dtoList;
    }

    private void personVerification(Person person) throws BadRequestException {
        Person personEmailVerify = personRepository.findByEmail(person.getEmail());
        Person personCPFVerify = personRepository.findByCpf(person.getCpf());

        if (personEmailVerify != null) {
            throw new BadRequestException("Email is already in use!");
        }

        if (personCPFVerify != null) {
            throw new BadRequestException("CPF is already in use!");
        }
    }
    
}
