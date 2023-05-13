package com.crudspringapi.crudspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspringapi.crudspringapi.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
