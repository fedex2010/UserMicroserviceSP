package com.example.demo.Exceptions;

import com.example.demo.Exceptions.RestException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RestException {

    public UserNotFoundException(String identifier) {
        super( HttpStatus.NOT_FOUND.toString(), "User " + identifier + " doesn't exist.");
    }

}
