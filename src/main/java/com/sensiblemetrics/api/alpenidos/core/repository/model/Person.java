package com.sensiblemetrics.api.alpenidos.core.repository.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Person entity
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private int age;

    /**
     * Constructor
     */
    public Person(final String name, final String surname, final int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
