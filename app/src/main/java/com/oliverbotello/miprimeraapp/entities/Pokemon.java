package com.oliverbotello.miprimeraapp.entities;

public class Pokemon {
    private String name;
    private String description;
    private int image;

    public Pokemon(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImage() {
        return this.image;
    }
}
