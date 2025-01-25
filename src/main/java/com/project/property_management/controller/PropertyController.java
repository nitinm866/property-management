package com.project.property_management.controller;

import com.project.property_management.dto.PropertyDTO;
import com.project.property_management.service.PropertyService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    //Using the below code you can access the property values.
    // ':' is mentioned at the end to avoid the error when value is null
    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello World "+name;
    }
    @GetMapping("/address/{id}")
    public String address(@PathVariable("id") int pincode){
        return "Bangalore "+pincode;
    }
    @PostMapping("/saveProperty")
    public ResponseEntity<PropertyDTO> save(@RequestBody PropertyDTO propertyDTO){
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/listProperties")
    public List<PropertyDTO> getAllProperties(){
        System.out.println(dbUrl);
        return propertyService.getAllProperties();
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO,propertyId);
        return propertyDTO;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyPrice(propertyDTO,propertyId);
        return propertyDTO;
    }

    @DeleteMapping("/properties/delete-property/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);

        ResponseEntity<Long> responseEntity = new ResponseEntity<>(null, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}
