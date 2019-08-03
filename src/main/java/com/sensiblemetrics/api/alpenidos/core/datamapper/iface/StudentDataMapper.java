package com.sensiblemetrics.api.alpenidos.core.datamapper.iface;

import com.sensiblemetrics.api.alpenidos.core.datamapper.exception.DataMapperException;
import com.sensiblemetrics.api.alpenidos.core.datamapper.model.Student;

import java.util.Optional;

/**
 * Interface lists out the possible behaviour for all possible student mappers
 */
public interface StudentDataMapper {

    Optional<Student> find(final int studentId);

    void insert(final Student student) throws DataMapperException;

    void update(final Student student) throws DataMapperException;

    void delete(final Student student) throws DataMapperException;
}
