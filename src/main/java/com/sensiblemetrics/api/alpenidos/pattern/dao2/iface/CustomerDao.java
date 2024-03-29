package com.sensiblemetrics.api.alpenidos.pattern.dao2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.dao2.model.Customer;
import com.sensiblemetrics.api.alpenidos.pattern.dao2.impl.DbCustomerDao;
import com.sensiblemetrics.api.alpenidos.pattern.dao2.impl.InMemoryCustomerDao;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * In an application the Data Access Object (DAO) is a part of Data access layer. It is an object
 * that provides an interface to some type of persistence mechanism. By mapping application calls
 * to the persistence layer, DAO provides some specific data operations without exposing details
 * of the database. This isolation supports the Single responsibility principle. It separates what
 * data accesses the application needs, in terms of domain-specific objects and data types
 * (the public interface of the DAO), from how these needs can be satisfied with a specific DBMS,
 * database schema, etc.
 *
 * <p>Any change in the way data is stored and retrieved will not change the client code as the
 * client will be using interface and need not worry about exact source.
 *
 * @see InMemoryCustomerDao
 * @see DbCustomerDao
 */
public interface CustomerDao {

    /**
     * @return all the customers as a stream. The stream may be lazily or eagerly evaluated based
     * on the implementation. The stream must be closed after use.
     * @throws Exception if any error occurs.
     */
    Stream<Customer> getAll() throws Exception;

    /**
     * @param id unique identifier of the customer.
     * @return an optional with customer if a customer with unique identifier <code>id</code>
     * exists, empty optional otherwise.
     * @throws Exception if any error occurs.
     */
    Optional<Customer> getById(final int id) throws Exception;

    /**
     * @param customer the customer to be added.
     * @return true if customer is successfully added, false if customer already exists.
     * @throws Exception if any error occurs.
     */
    boolean add(final Customer customer) throws Exception;

    /**
     * @param customer the customer to be updated.
     * @return true if customer exists and is successfully updated, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean update(final Customer customer) throws Exception;

    /**
     * @param customer the customer to be deleted.
     * @return true if customer exists and is successfully deleted, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean delete(final Customer customer) throws Exception;
}
