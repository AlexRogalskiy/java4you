package com.sensiblemetrics.api.alpenidos.pattern.prototype2.impl;

/**
 * Prototype
 */
public abstract class Prototype implements Cloneable {

    public abstract Object copy() throws CloneNotSupportedException;
}
