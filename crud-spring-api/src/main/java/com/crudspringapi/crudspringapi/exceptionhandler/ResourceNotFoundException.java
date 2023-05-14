package com.crudspringapi.crudspringapi.exceptionhandler;

public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
