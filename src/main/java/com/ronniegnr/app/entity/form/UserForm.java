package com.ronniegnr.app.entity.form;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String repeatedPassword;

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotEmpty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public String toString() {
        return "UserForm{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", password='" + password + '\'' +
            ", repeatedPassword='" + repeatedPassword + '\'' +
            '}';
    }
}
