package com.example.demospring.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@Entity
@Transactional
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="avatar_url")
    private String url;

    @Column(name="date")
    private String dateCreated;

    @Column(name="total_owned_property")
    private String totalOwnedProperty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTotalOwnedProperty() {
        return totalOwnedProperty;
    }

    public void setTotalOwnedProperty(String totalOwnedProperty) {
        this.totalOwnedProperty = totalOwnedProperty;
    }
}
