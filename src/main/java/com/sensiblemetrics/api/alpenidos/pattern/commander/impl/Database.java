package com.sensiblemetrics.api.alpenidos.pattern.commander.impl;

import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;

/**
 * Database abstract class is extended by all databases in our example. The add and get
 * methods are used by the respective service to add to database or get from database.
 *
 * @param <T> T is the type of object being held by database.
 */
public abstract class Database<T> {

    public abstract T add(final T obj) throws DatabaseUnavailableException;

    public abstract T get(final String tId) throws DatabaseUnavailableException;
}
