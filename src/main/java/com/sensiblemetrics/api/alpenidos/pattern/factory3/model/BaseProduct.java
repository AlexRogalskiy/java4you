package com.sensiblemetrics.api.alpenidos.pattern.factory3.model;

/**
 * Base class for all Products.
 * <p>
 * Not part of the Factory Method pattern per se, but saves duplicating keeping the isTaxable state across all the Product types.
 */
abstract class BaseProduct implements Product {

    private boolean isTaxable;

    @Override
    public void setIsTaxable(boolean isTaxable) {

        this.isTaxable = isTaxable;
    }

    @Override
    public boolean isTaxable() {

        return isTaxable;
    }
}
