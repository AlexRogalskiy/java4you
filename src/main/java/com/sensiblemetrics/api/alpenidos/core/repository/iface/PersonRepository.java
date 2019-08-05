package com.sensiblemetrics.api.alpenidos.core.repository.iface;

import com.sensiblemetrics.api.alpenidos.core.repository.model.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Person repository
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    Person findByName(final String name);
}
