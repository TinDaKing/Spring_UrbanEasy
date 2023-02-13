package com.example.demospring.model;

public class RequestPayload<T> {
    private T key;
    private String action;

    public RequestPayload(T key, String action) {
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

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
