package fr.erazor.project.dto.user;

import java.util.Date;

public class UserUpdateDTO {
    private String username;
    private String email;

    public UserUpdateDTO(){
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
