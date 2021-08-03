package com.sensiblemetrics.api.alpenidos.pattern.unit_of_work;

import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.impl.StudentRepository;
import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.model.Student;
import com.sensiblemetrics.api.alpenidos.pattern.unit_of_work.model.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link UnitOfWorkPatternLoader} Application for managing student data.
 */
public class UnitOfWorkPatternLoader {
    /**
     * @param args no argument sent
     */
    public static void main(final String[] args) {
        final Student ram = new Student(1, "Ram", "Street 9, Cupertino");
        final Student shyam = new Student(2, "Shyam", "Z bridge, Pune");
        final Student gopi = new Student(3, "Gopi", "Street 10, Mumbai");

        final Map<String, List<Student>> context = new HashMap<>();
        final StudentDatabase studentDatabase = new StudentDatabase();
        final StudentRepository studentRepository = new StudentRepository(context, studentDatabase);

        studentRepository.registerNew(ram);
        studentRepository.registerModified(shyam);
        studentRepository.registerDeleted(gopi);
        studentRepository.commit();
    }
}
