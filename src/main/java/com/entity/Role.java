package com.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public Role() {}

    public Role(String roleName) {
        this.name = RoleName.valueOf(roleName);
    }

    public Role(RoleName name) {
        this.name = name;
    }
}
