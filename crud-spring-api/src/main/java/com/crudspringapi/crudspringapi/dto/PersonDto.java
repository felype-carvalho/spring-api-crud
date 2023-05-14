package com.crudspringapi.crudspringapi.dto;

import java.util.List;

import com.crudspringapi.crudspringapi.model.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long id;
    
    private String name;
    
    private String email;
    
    private String cpf;

    private List<Address> addresses;
}
