package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String meesage)
    {
        super(meesage);
    }

}
