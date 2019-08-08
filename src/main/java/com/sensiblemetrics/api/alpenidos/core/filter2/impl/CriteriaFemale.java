package com.sensiblemetrics.api.alpenidos.core.filter2.impl;

import com.sensiblemetrics.api.alpenidos.core.filter2.iface.Criteria;
import com.sensiblemetrics.api.alpenidos.core.filter2.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(final List<Person> persons) {
        final List<Person> femalePersons = new ArrayList<>();
        for (final Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
