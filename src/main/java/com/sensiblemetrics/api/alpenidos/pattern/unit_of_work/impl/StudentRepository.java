package com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.impl;

import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.iface.IUnitOfWork;
import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.model.Student;
import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.model.StudentDatabase;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link StudentRepository} Student database repository.
 * supports unit of work for student data.
 */
@Slf4j
public class StudentRepository implements IUnitOfWork<Student> {
    private Map<String, List<Student>> context;
    private StudentDatabase studentDatabase;

    /**
     * @param context         set of operations to be perform during commit.
     * @param studentDatabase Database for student records.
     */
    public StudentRepository(final Map<String, List<Student>> context, final StudentDatabase studentDatabase) {
        this.context = context;
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void registerNew(final Student student) {
        log.info("Registering {} for insert in context.", student.getName());
        this.register(student, IUnitOfWork.INSERT);
    }

    @Override
    public void registerModified(final Student student) {
        log.info("Registering {} for modify in context.", student.getName());
        this.register(student, IUnitOfWork.MODIFY);
    }

    @Override
    public void registerDeleted(final Student student) {
        log.info("Registering {} for delete in context.", student.getName());
        this.register(student, IUnitOfWork.DELETE);
    }

    private void register(final Student student, final String operation) {
        List<Student> studentsToOperate = this.context.get(operation);
        if (studentsToOperate == null) {
            studentsToOperate = new ArrayList<>();
        }
        studentsToOperate.add(student);
        this.context.put(operation, studentsToOperate);
    }

    /**
     * All UnitOfWork operations are batched and executed together on commit only.
     */
    @Override
    public void commit() {
        if (this.context == null || this.context.size() == 0) {
            return;
        }
        log.info("Commit started");
        if (this.context.containsKey(IUnitOfWork.INSERT)) {
            this.commitInsert();
        }
        if (this.context.containsKey(IUnitOfWork.MODIFY)) {
            this.commitModify();
        }
        if (this.context.containsKey(IUnitOfWork.DELETE)) {
            this.commitDelete();
        }
        log.info("Commit finished.");
    }

    private void commitInsert() {
        final List<Student> studentsToBeInserted = this.context.get(IUnitOfWork.INSERT);
        for (final Student student : studentsToBeInserted) {
            log.info("Saving {} to database.", student.getName());
            this.studentDatabase.insert(student);
        }
    }

    private void commitModify() {
        final List<Student> modifiedStudents = this.context.get(IUnitOfWork.MODIFY);
        for (final Student student : modifiedStudents) {
            log.info("Modifying {} to database.", student.getName());
            this.studentDatabase.modify(student);
        }
    }

    private void commitDelete() {
        final List<Student> deletedStudents = this.context.get(IUnitOfWork.DELETE);
        for (final Student student : deletedStudents) {
            log.info("Deleting {} to database.", student.getName());
            this.studentDatabase.delete(student);
        }
    }
}
