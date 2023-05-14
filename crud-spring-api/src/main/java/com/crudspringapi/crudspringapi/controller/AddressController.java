package com.crudspringapi.crudspringapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspringapi.crudspringapi.exceptionhandler.ResourceNotFoundException;
import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.repository.AddressRepository;
import com.crudspringapi.crudspringapi.repository.PersonRepository;
import com.crudspringapi.crudspringapi.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/persons/{personId}/address")
    public ResponseEntity<Address> createAddress(@PathVariable(value = "personId") Long personId,
            @RequestBody Address addressRequest) {
        Address address = addressService.createAddress(personId, addressRequest);

        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
}