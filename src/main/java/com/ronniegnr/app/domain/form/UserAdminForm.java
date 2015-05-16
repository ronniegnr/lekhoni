package com.ronniegnr.app.domain.form;

import com.ronniegnr.app.domain.entity.User;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class UserAdminForm {

    private int id;
    private String name;
    private String email;
    private String phone;
    private User.Status status;
    private String password;

    @NotNull
    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @NotNull
    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAdminForm{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", status=" + status + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
