package com.sensiblemetrics.api.alpenidos.core.service_layer.common;

import java.util.List;

/**
 * Dao interface.
 *
 * @param <E>
 */
public interface Dao<E extends BaseEntity> {

    E find(final Long id);

    void persist(final E entity);

    E merge(final E entity);

    void delete(final E entity);

    List<E> findAll();
}
