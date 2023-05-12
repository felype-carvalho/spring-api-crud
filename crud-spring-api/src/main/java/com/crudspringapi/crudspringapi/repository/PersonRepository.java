package com.crudspringapi.crudspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspringapi.crudspringapi.model.Person;

public interface PersonRepository  extends JpaRepository<Person, Long> {
    
}
