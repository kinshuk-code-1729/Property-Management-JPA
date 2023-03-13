package com.kbcompany.PropertyManagement.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BuisnessException extends RuntimeException{
    private List<ErrorModel> errors;
    public BuisnessException(List<ErrorModel> errors){
        this.errors = errors;
    }
}
