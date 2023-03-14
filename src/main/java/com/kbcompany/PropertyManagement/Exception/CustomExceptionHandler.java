package com.kbcompany.PropertyManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BuisnessException.class)
    public ResponseEntity<List<ErrorModel>> handleBuisnessException(BuisnessException buisnessException){
        System.out.println("BuisnessException is thrown");
        return new ResponseEntity<List<ErrorModel>>(buisnessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
