package com.sensiblemetrics.api.alpenidos.core.filter2.impl;

import com.sensiblemetrics.api.alpenidos.core.filter2.model.Person;
import com.sensiblemetrics.api.alpenidos.core.filter2.iface.Criteria;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AndCriteria implements Criteria {
    private final Criteria firstCriteria;
    private final Criteria secondCriteria;

    @Override
    public List<Person> meetCriteria(final List<Person> persons) {
        return this.secondCriteria.meetCriteria(this.firstCriteria.meetCriteria(persons));
    }
}
