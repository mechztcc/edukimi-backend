package com.edukimi.api.dto;

import java.io.Serializable;

public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;

    private String date;

    private String description;

    private Integer schoolId;


    public EventDTO() {
    }

    public EventDTO(String name, String date, String description, Integer schoolId) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.schoolId = schoolId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }



}
