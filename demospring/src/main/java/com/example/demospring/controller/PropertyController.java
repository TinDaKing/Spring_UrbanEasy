package com.example.demospring.controller;

import com.example.demospring.entity.Property;
import com.example.demospring.model.Payload;
import com.example.demospring.repository.PropertyRepository;
import com.example.demospring.model.RequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PropertyController {
    @Autowired
    PropertyRepository propertyRepository;

    @PostMapping("/property")
    Payload getProperty() {
        List<Property> propertyList =  propertyRepository.findAll();
        return new Payload(propertyList, propertyList.size());
    }

    @PostMapping("/property/update")
    void updateProperty(@RequestBody RequestPayload<Property> requestPayload) {
        propertyRepository.save(requestPayload.getKey());
    }
    @PostMapping("/property/remove")
    void removeProperty(@RequestBody RequestPayload<Property> requestPayload) {
       Property targetedProperty = requestPayload.getKey();
       propertyRepository.delete(targetedProperty);
    }

}
