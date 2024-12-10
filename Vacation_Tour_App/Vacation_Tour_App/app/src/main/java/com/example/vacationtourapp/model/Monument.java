package com.example.vacationtourapp.model;


public class Monument {
    private String name;
    private String description;
    private int image;

    // Constructor
    public Monument(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
