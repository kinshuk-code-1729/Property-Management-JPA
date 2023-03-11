package com.kbcompany.PropertyManagement.Controller;

import com.kbcompany.PropertyManagement.Model.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") // Class level mapping of URL to Controller class
public class CalculatorController {
    @GetMapping("/add/{n3}") // Method level Mapping of URL to controller function
    public Double add(@RequestParam("n1") Double n1,@RequestParam("n2") Double n2,@PathVariable("n3") Double n3){
        return n1+n2;
    }
    @GetMapping("/sub/{n1}/{n2}")
    public Double subtract(@PathVariable("n1") Double n1,@PathVariable("n2") Double n2){
        Double result = null;
        if(n1 > n2){
            result = n1 - n2;
        }
        else {
            result = n2 - n1;
        }
        return result;
    }
    @PostMapping("/pro")
    public ResponseEntity<Double> product(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getN1()*calculatorDTO.getN2()*calculatorDTO.getN3()*calculatorDTO.getN4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
