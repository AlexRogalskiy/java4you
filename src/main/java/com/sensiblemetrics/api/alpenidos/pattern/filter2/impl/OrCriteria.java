package com.sensiblemetrics.api.alpenidos.pattern.filter2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.filter2.model.Person;
import com.sensiblemetrics.api.alpenidos.pattern.filter2.iface.Criteria;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrCriteria implements Criteria {
    private final Criteria firstCriteria;
    private final Criteria secondCriteria;

    @Override
    public List<Person> meetCriteria(final List<Person> persons) {
        final List<Person> firstCriteriaPersons = this.firstCriteria.meetCriteria(persons);
        final List<Person> secondCriteriaPersons = this.secondCriteria.meetCriteria(persons);
        for (final Person person : secondCriteriaPersons) {
            if (!firstCriteriaPersons.contains(person)) {
                firstCriteriaPersons.add(person);
            }
        }
        return firstCriteriaPersons;
    }
}
