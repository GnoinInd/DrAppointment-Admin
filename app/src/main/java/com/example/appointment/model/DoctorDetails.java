package com.example.appointment.model;

public class DoctorDetails {

    private final int image;
    private final String doctor_name;
    private final String doctor_degree;
    private final String doctor_specialization;
    private final String gender;
    private final String doctor_availability;

    public DoctorDetails(int image, String doctor_name, String doctor_degree, String doctor_specialization, String gender, String doctor_availability) {
        this.image = image;
        this.doctor_name = doctor_name;
        this.doctor_degree = doctor_degree;
        this.doctor_specialization = doctor_specialization;
        this.gender = gender;
        this.doctor_availability = doctor_availability;
    }

    public int getImage() {
        return image;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getDoctor_degree() {
        return doctor_degree;
    }

    public String getDoctor_specialization() {
        return doctor_specialization;
    }

    public String getGender() {
        return gender;
    }

    public String getDoctor_availability() {
        return doctor_availability;
    }


}