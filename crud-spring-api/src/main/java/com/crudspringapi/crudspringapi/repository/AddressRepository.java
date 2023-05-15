package com.crudspringapi.crudspringapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspringapi.crudspringapi.model.Address;

import jakarta.transaction.Transactional;


public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findByPersonId(Long personId);

    @Transactional
    void deleteByPersonId(long personId);
    
}
