package com.sensiblemetrics.api.alpenidos.core.filter2;

import com.sensiblemetrics.api.alpenidos.core.filter2.iface.Criteria;
import com.sensiblemetrics.api.alpenidos.core.filter2.impl.*;
import com.sensiblemetrics.api.alpenidos.core.filter2.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
public class FilterPatternLoader {

    public static void main(final String... args) {
        final List<Person> persons = asList(
            new Person("Robert", "Male", "Single"),
            new Person("John", "Male", "Married"),
            new Person("Laura", "Female", "Married"),
            new Person("Diana", "Female", "Single"),
            new Person("Mike", "Male", "Single"),
            new Person("Bobby", "Male", "Single")
        );

        final Criteria male = new CriteriaMale();
        final Criteria female = new CriteriaFemale();
        final Criteria single = new CriteriaSingle();
        final Criteria singleMale = new AndCriteria(single, male);
        final Criteria singleOrFemale = new OrCriteria(single, female);

        log.info("Males: ");
        printPersons(male.meetCriteria(persons));

        log.info("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        log.info("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        log.info("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    private static void printPersons(final List<Person> persons) {
        for (final Person person : persons) {
            log.info("Person : [ Name : " + person.getName() +
                ", Gender : " + person.getGender() +
                ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
}
