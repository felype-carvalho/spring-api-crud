package com.crudspringapi.crudspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringapi.crudspringapi.exceptionhandler.BadRequestException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.model.Person;
import com.crudspringapi.crudspringapi.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void create(List<Address> listAddresses, Person person) throws BadRequestException{
        for (Address address : listAddresses) {
            address.setPerson(person);
            addressRepository.save(address);
        }
    }

    public List<Address> findAddressesByPersonId(Long personId) {
        List<Address> addressesList = addressRepository.findByPersonId(personId);
        
        return addressesList;
    }
    
}
