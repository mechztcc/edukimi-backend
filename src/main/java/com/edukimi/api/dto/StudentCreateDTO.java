package com.edukimi.api.dto;

import java.io.Serializable;

public class StudentCreateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;

    private String registration;

    private Boolean status;

    private String birth;

    private Integer classroom;

    private String parent;

    private String email;

    private String phone;

    private String street;

    private String number;

    private String zip;

    private String city;

    private String district;



    public StudentCreateDTO() {
    }

    public StudentCreateDTO(String name, String registration, Boolean status, String birth, Integer classroom, String parent, String email, String phone, String street, String number, String zip, String city, String district) {
        this.name = name;
        this.registration = registration;
        this.status = status;
        this.birth = birth;
        this.classroom = classroom;
        this.parent = parent;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.district = district;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassroom() {
        return this.classroom;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }



    public String getRegistration() {
        return this.registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getParent() {
        return this.parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
