package com.example.demospring.model;

import com.example.demospring.entity.Property;

public class PropertyRequestPayload {
    private Property key;
    private String action;

    public PropertyRequestPayload(Property key, String action) {
        this.key = key;
        this.action = action;
    }

    @Override
    public String toString() {
        return "PropertyRequestPayload{" +
                "key=" + key +
                ", action='" + action + '\'' +
                '}';
    }

    public Property getKey() {
        return key;
    }

    public void setKey(Property key) {
        this.key = key;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
