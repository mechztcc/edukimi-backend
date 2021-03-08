package com.edukimi.api.dto;

import java.io.Serializable;

public class ClassroomDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Boolean status;

    private Integer databaseId;


    public ClassroomDTO() {
    }

    public ClassroomDTO(String name, Boolean status, Integer databaseId) {
        this.name = name;
        this.status = status;
        this.databaseId = databaseId;
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

    public Integer getDatabaseId() {
        return this.databaseId;
    }

    public void setDatabaseId(Integer databaseId) {
        this.databaseId = databaseId;
    }

    
}
