package com.kbcompany.PropertyManagement.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();
        for (FieldError fe : fieldErrorList){
            logger.debug("Inside Field Validation : {} - {} ",fe.getField(),fe.getDefaultMessage());
            logger.info("Inside Field Validation : {} - {} ",fe.getField(),fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BuisnessException.class)
    public ResponseEntity<List<ErrorModel>> handleBuisnessException(BuisnessException bex){
        for(ErrorModel erm : bex.getErrors()) {
            logger.debug("BuisnessException is thrown - level debug : {} - {} ", erm.getCode(),erm.getMessage());
            logger.info("BuisnessException is thrown - level info : {} - {} ", erm.getCode(),erm.getMessage());
            logger.warn("BuisnessException is thrown - level warn : {} - {} ", erm.getCode(),erm.getMessage());
            logger.error("BuisnessException is thrown - level error : {} - {} ", erm.getCode(),erm.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
