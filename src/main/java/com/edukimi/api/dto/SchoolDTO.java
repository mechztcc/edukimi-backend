package com.edukimi.api.dto;

import java.io.Serializable;

public class SchoolDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;

    private Boolean status;




    public SchoolDTO() {
    }

    public SchoolDTO(String name, Boolean status) {
        this.name = name;
        this.status = status;
 
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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




}
