package com.sensiblemetrics.api.alpenidos.pattern.prototype.model;

import com.sensiblemetrics.api.alpenidos.pattern.prototype.iface.Prototype;

/**
 * Created by luisburgos on 23/07/15.
 */
public class ConcretePrototypeOne implements Prototype {
    @Override
    public ConcretePrototypeOne clone() {
        ConcretePrototypeOne copyObject = null;
        try {
            copyObject = (ConcretePrototypeOne) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return copyObject;
    }

    @Override
    public String toString() {
        return "Concrete Prototype One";
    }
}
