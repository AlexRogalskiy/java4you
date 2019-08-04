package com.sensiblemetrics.api.alpenidos.core.monad.model;

import com.sensiblemetrics.api.alpenidos.core.monad.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Definition
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private Sex sex;
    private String email;
}
