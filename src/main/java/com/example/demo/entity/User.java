package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @ManyToOne(targetEntity = Role.class)
    private Role roles;

    public User() {
    }

    public User(String email, String password, Role roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
