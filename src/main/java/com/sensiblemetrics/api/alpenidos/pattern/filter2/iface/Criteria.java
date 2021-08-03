package com.sensiblemetrics.api.alpenidos.pattern.filter2.iface;

import com.sensiblemetrics.api.alpenidos.pattern.filter2.model.Person;

import java.util.List;

public interface Criteria {

    List<Person> meetCriteria(final List<Person> persons);
}
