package com.example.demospring.model;

import com.example.demospring.entity.Property;

import java.util.List;


public class PropertyPayload {
    private List<Property> result;
    private int count;
    public PropertyPayload(List<Property> result, int count) {
        this.result = result;
        this.count = count;
    }

    public List<Property> getResult() {
        return result;
    }

    public void setResult(List<Property> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
