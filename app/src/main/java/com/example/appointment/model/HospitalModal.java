package com.example.appointment.model;

import java.util.List;

public class HospitalModal {
    private String hospital_name;
    private Address hospital_address;
    private List<String> specialization;
    private List<Doctor> doctor_list;
    private String category_type;

    public String getHospital_name() {
        return hospital_name;
    }

    public Address getHospital_address() {
        return hospital_address;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

    public List<Doctor> getDoctor_list() {
        return doctor_list;
    }

    public String getCategory_type() {
        return category_type;
    }

    static class Doctor {
        private final String doctor_name;
        private final String doctor_degree;
        private final String doctor_specialization;
        private final String gender;
        private final String doctor_availability;


        public Doctor(String doctor_name, String doctor_degree, String doctor_specialization, String gender, String doctor_availability) {
            this.doctor_name = doctor_name;
            this.doctor_degree = doctor_degree;
            this.doctor_specialization = doctor_specialization;
            this.gender = gender;
            this.doctor_availability = doctor_availability;
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


    static class Address {
        private String street;
        private String city;
        private String state;
        private String zip_code;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZip_code() {
            return zip_code;
        }
    }
}
