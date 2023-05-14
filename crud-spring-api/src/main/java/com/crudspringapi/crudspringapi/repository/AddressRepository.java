package com.crudspringapi.crudspringapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crudspringapi.crudspringapi.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{
    @Query(value = "SELECT * FROM ADDRESS WHERE PERSON_ID = ?1", nativeQuery = true)
    public List<Address> findByPersonId(long personId);
}
