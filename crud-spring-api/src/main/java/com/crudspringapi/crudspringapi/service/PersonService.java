package com.crudspringapi.crudspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressService addressService;

    public Person create(Person person) throws Exception {
        List<Address> addresses = person.getAddresses();

        personRepository.save(person);
        addressService.create(addresses, person);
        return person;
    }

    private void personVerification(Person person) throws Exception {
        Person personEmailVerify = personRepository.findByEmail(person.getEmail());
        Person personCPFVerify = personRepository.findByCPF(person.getCpf());

        if (personEmailVerifi != null) {
            throw new BadRequestException("Email is already in use!");
        }

        if (person.getLegalNumber() == null) {
            throw new BadRequestException("Legal number is required!");
        }
    }
}
