package com.example.demospring.controller;

import com.example.demospring.entity.Property;
import com.example.demospring.entity.User;
import com.example.demospring.model.PropertyInterface;
import com.example.demospring.repository.PropertyReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {
    @Autowired
    private PropertyReposity propertyReposity;

    @GetMapping("/properties")
    public List<PropertyInterface> getAllProperties(){
        return propertyReposity.selectAllProperty();
    }

    @PostMapping("/properties/delete")
    public ResponseEntity deleteUser(@RequestBody String id){
        propertyReposity.deleteById(Long.parseLong(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/properties/edit")
    public ResponseEntity updateProperty(@RequestBody Property property){
        propertyReposity.updateProperty(Long.toString(property.getId()),property.getName(), property.getCity(),property.getCountry(),property.getPrice());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
