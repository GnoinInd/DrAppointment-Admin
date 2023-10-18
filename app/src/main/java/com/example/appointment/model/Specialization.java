package com.example.appointment.model;

public class Specialization {

    private int image;
    private String name;

    public Specialization(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Specialization(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
