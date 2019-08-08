package com.sensiblemetrics.api.alpenidos.core.filter2.impl;

import com.sensiblemetrics.api.alpenidos.core.filter2.iface.Criteria;
import com.sensiblemetrics.api.alpenidos.core.filter2.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(final List<Person> persons) {
        final List<Person> singlePersons = new ArrayList<>();
        for (final Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
