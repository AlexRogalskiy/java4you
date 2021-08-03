package com.sensiblemetrics.api.alpenidos.pattern.data_mapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class defining Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Student implements Serializable {

    private static final long serialVersionUID = 9029664651330712625L;

    private int studentId;
    private String name;
    private char grade;
}
