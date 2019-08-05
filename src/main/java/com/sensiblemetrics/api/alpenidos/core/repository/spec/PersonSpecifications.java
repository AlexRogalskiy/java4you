package com.sensiblemetrics.api.alpenidos.core.repository.spec;

import com.sensiblemetrics.api.alpenidos.core.repository.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Helper class, includes vary Specification as the abstraction of sql query criteria
 */
public class PersonSpecifications {

    /**
     * Specifications stating the Between (From - To) Age Specification
     */
    @RequiredArgsConstructor
    public static class AgeBetweenSpec implements Specification<Person> {
        private final int from;
        private final int to;

        @Override
        public Predicate toPredicate(final Root<Person> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
            return cb.between(root.get("age"), this.from, this.to);
        }
    }

    /**
     * Name specification
     */
    @RequiredArgsConstructor
    public static class NameEqualSpec implements Specification<Person> {
        public final String name;

        /**
         * Get predicate
         */
        public Predicate toPredicate(final Root<Person> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
            return cb.equal(root.get("name"), this.name);
        }
    }
}
