package com.sensiblemetrics.api.alpenidos.core.type_object.model;

import lombok.Data;

/**
 * The Candy class has a field type, which represents the 'type' of candy. The objects
 * are created by parsing the candy.json file.
 */
@Data
public class Candy {

    public enum Type {
        crushableCandy,
        rewardFruit
    }

    private String name;
    private Candy parent;
    private String parentName;
    private int points;
    private Type type;

    public Candy(final String name, final String parentName, final Type type, final int points) {
        this.name = name;
        this.parent = null;
        this.type = type;
        this.points = points;
        this.parentName = parentName;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int a) {
        this.points = a;
    }

    public Type getType() {
        return this.type;
    }
}
