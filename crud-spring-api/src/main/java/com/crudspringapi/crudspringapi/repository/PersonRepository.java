package com.crudspringapi.crudspringapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspringapi.crudspringapi.model.Person;


public interface PersonRepository  extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByCpf(String cpf);
}
