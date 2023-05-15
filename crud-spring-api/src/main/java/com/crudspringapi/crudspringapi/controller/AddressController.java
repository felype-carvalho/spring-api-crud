package com.crudspringapi.crudspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspringapi.crudspringapi.model.Address;
import com.crudspringapi.crudspringapi.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/persons/{personId}/addresses")
    public ResponseEntity<List<Address>> getAllAddressesByPersonId(
            @PathVariable(value = "personId") Long personId) {
        List<Address> addresses = addressService.getAllAddressesByPersonId(personId);

        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressesById(@PathVariable(value = "id") Long id) {
        Address address = addressService.getAddressesById(id);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/persons/{personId}/addresses")
    public ResponseEntity<Address> createAddress(@PathVariable(value = "personId") Long personId,
            @RequestBody Address addressRequest) {
        Address address = addressService.createAddress(personId, addressRequest);

        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address addressRequest) {
        Address address = addressService.updateAddress(id, addressRequest);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<HttpStatus> deleteAddresss(@PathVariable("id") long id) {
        addressService.deleteAddresss(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/persons/{personId}/addresses")
    public ResponseEntity<List<Address>> deleteAllAddressesOfPerson(
            @PathVariable(value = "personId") Long personId) {
        addressService.deleteAllAddressesOfPerson(personId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}