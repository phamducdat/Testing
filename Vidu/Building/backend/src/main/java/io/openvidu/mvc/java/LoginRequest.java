package io.openvidu.mvc.java;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String user;

    @NotBlank
    private String password;

    public String getUsername() {
        return user;
    }

    public void setUsername(String username) {
        this.user = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
