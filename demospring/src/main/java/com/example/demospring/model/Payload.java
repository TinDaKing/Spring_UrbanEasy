package com.example.demospring.model;

import java.util.List;


public class Payload<T> {
    private List<T> result;
    private int count;
    public Payload(List<T> result, int count) {
        this.result = result;
        this.count = count;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
