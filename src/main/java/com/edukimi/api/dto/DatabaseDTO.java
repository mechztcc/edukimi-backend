package com.edukimi.api.dto;

import java.io.Serializable;

public class DatabaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;

    private Boolean status;

    private Integer userId;


    public DatabaseDTO() {
    }

    public DatabaseDTO(String name, Boolean status, Integer userId) {
        this.name = name;
        this.status = status;
        this.userId = userId;
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

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
