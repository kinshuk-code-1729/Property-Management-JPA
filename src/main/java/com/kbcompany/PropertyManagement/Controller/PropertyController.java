package com.kbcompany.PropertyManagement.Controller;

import com.kbcompany.PropertyManagement.Model.PropertyDTO;
import com.kbcompany.PropertyManagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
       List<PropertyDTO> propertyList = propertyService.getAllProperties();
       ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList,HttpStatus.OK);
       return responseEntity;
    }
    @PutMapping("/properties/{propertyID}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID){
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-description/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyID){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-price/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyID){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO,propertyID);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyID}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyID){
        propertyService.deleteProperty(propertyID);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
