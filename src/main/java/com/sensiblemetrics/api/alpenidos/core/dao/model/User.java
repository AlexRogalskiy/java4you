package com.sensiblemetrics.api.alpenidos.core.dao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }
}
