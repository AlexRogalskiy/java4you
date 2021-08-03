package com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.iface;

/**
 * @param <T> Any generic entity
 */
public interface IUnitOfWork<T> {
    String INSERT = "INSERT";
    String DELETE = "DELETE";
    String MODIFY = "MODIFY";

    /**
     * Any register new operation occurring on UnitOfWork is only going to be performed on commit.
     */
    void registerNew(final T entity);

    /**
     * Any register modify operation occurring on UnitOfWork is only going to be performed on commit.
     */
    void registerModified(final T entity);

    /**
     * Any register delete operation occurring on UnitOfWork is only going to be performed on commit.
     */
    void registerDeleted(final T entity);

    /***
     * All UnitOfWork operations batched together executed in commit only.
     */
    void commit();
}
