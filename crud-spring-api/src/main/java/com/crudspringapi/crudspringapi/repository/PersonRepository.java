package com.crudspringapi.crudspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crudspringapi.crudspringapi.model.Person;


public interface PersonRepository  extends JpaRepository<Person, Long> {
    public Person findByEmail(String email);
    public Person findByCpf(String cpf);
    

}
