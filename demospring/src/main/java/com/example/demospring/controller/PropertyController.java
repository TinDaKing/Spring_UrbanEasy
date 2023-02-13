package com.example.demospring.controller;

import com.example.demospring.entity.Property;
import com.example.demospring.model.PropertyPayload;
import com.example.demospring.repository.PropertyRepository;
import com.example.demospring.model.PropertyRequestPayload;
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
    PropertyPayload getProperty() {
        List<Property> propertyList =  propertyRepository.findAll();
        return new PropertyPayload(propertyList, propertyList.size());
    }

    @PostMapping("/property/update")
    void updateProperty(@RequestBody PropertyRequestPayload propertyRequestPayload) {
        propertyRepository.save(propertyRequestPayload.getKey());
    }
    @PostMapping("/property/remove")
    void removeProperty(@RequestBody PropertyRequestPayload propertyRequestPayload) {
       Property targetedProperty = propertyRequestPayload.getKey();
       propertyRepository.delete(targetedProperty);
    }

}
