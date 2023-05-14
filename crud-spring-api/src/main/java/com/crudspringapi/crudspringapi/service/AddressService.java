package com.crudspringapi.crudspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.exceptionhandler.ResourceNotFoundException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.AddressRepository;
import com.crudspringapi.crudspringapi.repository.PersonRepository;

@Service
public class AddressService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddressesByPersonId(Long personId) {
        if (!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Not found Person with id = " + personId);
        }

        List<Address> addresses = addressRepository.findByPersonId(personId);

        return addresses;
    }

    public Address getAddressesById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Address with id = " + id));

        return address;

    }

    public Address createAddress(Long personId, Address addressRequest) {
        Address address = personRepository.findById(personId).map(person -> {
            addressRequest.setPerson(person);
            return addressRepository.save(addressRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Address with id = " + personId));

        return address;
    }

    // public void create(List<Address> listAddresses, Person person) throws
    // BadRequestException{
    // for (Address address : listAddresses) {
    // address.setPerson(person);
    // addressRepository.save(address);
    // }
    // }

    // public List<Address> findAddressesByPersonId(Long personId) {
    // List<Address> addressesList = addressRepository.findByPersonId(personId);

    // return addressesList;
    // }

}
