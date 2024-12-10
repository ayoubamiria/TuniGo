package com.example.vacationtourapp.model;

public class Hotel {
    private String name;
    private String description;
    private int imageResId;

    // Constructor
    public Hotel(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
