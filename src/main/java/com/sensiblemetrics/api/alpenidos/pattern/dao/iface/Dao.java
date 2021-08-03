package com.sensiblemetrics.api.alpenidos.pattern.dao.iface;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(final long id);

    List<T> getAll();

    void save(final T t);

    void update(final T t, final String[] params);

    void delete(final T t);
}
