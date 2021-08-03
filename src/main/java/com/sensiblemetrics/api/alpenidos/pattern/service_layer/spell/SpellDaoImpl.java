package com.sensiblemetrics.api.alpenidos.pattern.service_layer.spell;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.DaoBaseImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * SpellDao implementation.
 */
public class SpellDaoImpl extends DaoBaseImpl<Spell> implements SpellDao {

    @Override
    public Spell findByName(final String name) {
        Transaction tx = null;
        Spell result = null;
        try (final Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Spell> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
            final Root<Spell> root = criteriaQuery.from(this.persistentClass);
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            final TypedQuery<Spell> query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
            result = query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        return result;
    }
}
