package com.edukimi.api.dto;

import java.util.Objects;

public class UserLoginDTO {
    
    private String email;

    private String password;


    public UserLoginDTO() {
    }

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserLoginDTO)) {
            return false;
        }
        UserLoginDTO userLoginDTO = (UserLoginDTO) o;
        return Objects.equals(email, userLoginDTO.email) && Objects.equals(password, userLoginDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

}
