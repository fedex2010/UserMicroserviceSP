package com.example.demo.Exceptions;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFoundException(HttpServletRequest req,UserNotFoundException ex) {

        logger.error("User not found ", req.getMethod(), req.getRequestURI());

        Map<String, String> mapResponse = new HashMap<>();
        mapResponse.put("message",ex.getMessage());
        mapResponse.put("code",ex.getStatusCode());

        return new ResponseEntity<>(mapResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }

}