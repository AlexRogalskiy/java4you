package com.sensiblemetrics.api.alpenidos.core.data_mapper.impl;

import com.sensiblemetrics.api.alpenidos.core.data_mapper.exception.DataMapperException;
import com.sensiblemetrics.api.alpenidos.core.data_mapper.iface.StudentDataMapper;
import com.sensiblemetrics.api.alpenidos.core.data_mapper.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementation of Actions on Students Data
 */
@Data
public final class StudentDataMapperImpl implements StudentDataMapper {

    /* Note: Normally this would be in the form of an actual database */
    private final List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> find(final int studentId) {
        return this.getStudents().stream().filter(s -> s.getStudentId() == studentId).findFirst();
    }

    @Override
    public void update(final Student studentToBeUpdated) throws DataMapperException {
        final Student result = this.getStudents()
            .stream()
            .filter(s -> Objects.equals(s.getStudentId(), studentToBeUpdated.getStudentId()))
            .findFirst()
            .orElseThrow(() -> new DataMapperException("Student [" + studentToBeUpdated.getName() + "] is not found"));
        result.setGrade(studentToBeUpdated.getGrade());
    }

    @Override
    public void insert(final Student studentToBeInserted) throws DataMapperException {
        /* Check with existing students */
        if (!this.getStudents().contains(studentToBeInserted)) {
            /* Add student in list */
            this.getStudents().add(studentToBeInserted);
        } else {
            /* Throw user error after wrapping in a runtime exception */
            throw new DataMapperException("Student already [" + studentToBeInserted.getName() + "] exists");
        }
    }

    @Override
    public void delete(final Student studentToBeDeleted) throws DataMapperException {
        final Student result = this.getStudents()
            .stream()
            .filter(s -> Objects.equals(s.getStudentId(), studentToBeDeleted.getStudentId()))
            .findFirst()
            .orElseThrow(() -> new DataMapperException("Student [" + studentToBeDeleted.getName() + "] is not found"));
        this.getStudents().remove(result);
    }
}
