package com.ag.blog_app_apis.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private int id;
    @NotEmpty
    @Size(min = 4, max = 50, message = "Name must be between 4 characters to 50 characters !!")
    private String name;
    @Email(message = "This email is not valid !!")
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#@])[A-Za-z0-9#@]{10}$", message = "Password must contain Exactly 10 characters, At least 1 uppercase letter, At least 1 lowercase letter, At least 1 special character (# or @) and At least 1 digit")
    private String password;
    @NotEmpty
    private String about;

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }*/
}
