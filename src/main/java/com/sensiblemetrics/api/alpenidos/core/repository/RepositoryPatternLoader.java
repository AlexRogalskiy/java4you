package com.sensiblemetrics.api.alpenidos.core.repository;

import com.sensiblemetrics.api.alpenidos.core.repository.config.DbConfiguration;
import com.sensiblemetrics.api.alpenidos.core.repository.iface.PersonRepository;
import com.sensiblemetrics.api.alpenidos.core.repository.model.Person;
import com.sensiblemetrics.api.alpenidos.core.repository.spec.PersonSpecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

/**
 * Repository pattern mediates between the domain and data mapping layers using a collection-like
 * interface for accessing domain objects. A system with complex domain model often benefits from a
 * layer that isolates domain objects from the details of the database access code and in such
 * systems it can be worthwhile to build another layer of abstraction over the mapping layer where
 * query construction code is concentrated. This becomes more important when there are a large
 * number of domain classes or heavy querying. In these cases particularly, adding this layer helps
 * minimize duplicate query logic.
 * <p>
 * In this example we utilize Spring Data to automatically generate a repository for us from the
 * {@link Person} domain object. Using the {@link PersonRepository} we perform CRUD operations on
 * the entity, moreover, the query by {@link org.springframework.data.jpa.domain.Specification} are
 * also performed. Underneath we have configured in-memory H2 database for which schema is created
 * and dropped on each run.
 */
@Slf4j
public class RepositoryPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class);
        final PersonRepository repository = context.getBean(PersonRepository.class);

        final Person peter = new Person("Peter", "Sagan", 17);
        final Person nasta = new Person("Nasta", "Kuzminova", 25);
        final Person john = new Person("John", "lawrence", 35);
        final Person terry = new Person("Terry", "Law", 36);

        // Add new Person records
        repository.save(peter);
        repository.save(nasta);
        repository.save(john);
        repository.save(terry);

        // Count Person records
        log.info("Count Person records: {}", repository.count());

        // Print all records
        repository.findAll().forEach(p -> log.info(p.toString()));

        // Update Person
        nasta.setName("Barbora");
        nasta.setSurname("Spotakova");
        repository.save(nasta);

        log.info("Find by id 2: {}", repository.findById(2L));

        // Remove record from Person
        repository.delete(nasta);

        // count records
        log.info("Count Person records: {}", repository.count());

        // find by name
        final Optional<Person> personOptional = repository.findOne(new PersonSpecifications.NameEqualSpec("John"));
        personOptional.ifPresent(p -> log.info("Find by John is {}", p));

        // find by age
        repository.findAll(new PersonSpecifications.AgeBetweenSpec(20, 40)).forEach(p -> log.info(p.toString()));
        context.close();
    }
}
