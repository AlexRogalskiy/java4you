package com.sensiblemetrics.api.alpenidos.core.factory3.model;

/**
 * The Product interface for all product types.
 * <p>
 * Massively simplified for the demo!
 */
public interface Product {

    void setIsTaxable(boolean isTaxable);

    boolean isTaxable();

    String getProductDetails();
}
