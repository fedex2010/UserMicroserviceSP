package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class RestException extends Exception{
    String statusCode;
    String message;

    public RestException(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestException(){

    }
}
