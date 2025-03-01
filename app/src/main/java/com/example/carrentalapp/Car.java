package com.example.carrentalapp;

public class Car {
    private String name;
    private String details;

    public Car(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }
}