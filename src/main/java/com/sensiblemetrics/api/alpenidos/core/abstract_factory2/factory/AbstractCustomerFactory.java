package com.sensiblemetrics.api.alpenidos.core.abstract_factory2.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.account.Account;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.address.Address;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.product.Product;

/**
 * This is the Abstract Factory class providing operations that all concrete factory classes must override and implement to build stuff.
 * <p>
 * Yes, this could have been an interface, but the 'abstract class' bit clearly shows we're using the Abstract Factory pattern for the demo here.
 * <p>
 * The Abstract Factory provides the operations for building the family of parts that make up a Customer.
 * <p>
 * One thing to note, the Abstract Factory pattern does <em>not</em> create an actual Customer object; it only creates the (family of) parts that make it up.
 */
public abstract class AbstractCustomerFactory {

    /**
     * Creates an Address object.
     */
    public abstract Address createAddress();

    /**
     * Creates an Account object.
     *
     * @return
     */
    public abstract Account createAccount();

    /**
     * Creates a Product object.
     */
    public abstract Product createProduct();
}
