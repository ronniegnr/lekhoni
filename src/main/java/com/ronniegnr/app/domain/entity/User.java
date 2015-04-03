package com.ronniegnr.app.domain.entity;

import com.ronniegnr.app.domain.form.UserAdminForm;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    public enum Sex { MALE, FEMALE }
    public enum Role { USER, ADMIN }
    public enum Status { PENDING, ACTIVE, INACTIVE }

    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String avatar;
    private Sex sex;
    private Role role;
    private Status status;
    private Timestamp created;
    private Timestamp updated;

    private List<Post> posts;
    private List<Comment> comments;

    public User()
    {
        this.role = Role.USER;
        this.status = Status.PENDING;
        this.created = new Timestamp(new Date().getTime());
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotBlank
    @Length(max = 255)
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Length(max = 512)
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @Length(max = 255)
    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(max = 255)
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Column(name = "avatar", length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @NotNull
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @OneToMany(mappedBy = "user") // user is property of relationship holding table
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "user")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", sex='" + sex + '\'' +
            ", avatar='" + avatar + '\'' +
            ", role=" + role +
            ", status=" + status +
            ", created=" + created +
            ", updated=" + updated +
            ", posts=" + posts +
            '}';
    }

    public UserAdminForm toUserAdminForm() {
        UserAdminForm userAdminForm = new UserAdminForm();

        userAdminForm.setId(id);
        userAdminForm.setName(name);
        userAdminForm.setEmail(email);
        userAdminForm.setPhone(phone);

        return userAdminForm;
    }

}
