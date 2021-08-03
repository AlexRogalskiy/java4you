package com.sensiblemetrics.api.alpenidos.pattern.filter2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.filter2.iface.Criteria;
import com.sensiblemetrics.api.alpenidos.pattern.filter2.model.Person;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(final List<Person> persons) {
        final List<Person> malePersons = new ArrayList<>();
        for (final Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
