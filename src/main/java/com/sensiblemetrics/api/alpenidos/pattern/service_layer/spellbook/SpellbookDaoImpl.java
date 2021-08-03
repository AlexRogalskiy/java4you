package com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.DaoBaseImpl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * SpellbookDao implementation.
 */
public class SpellbookDaoImpl extends DaoBaseImpl<Spellbook> implements SpellbookDao {

    @Override
    public Spellbook findByName(final String name) {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        Spellbook result = null;
        try {
            tx = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Spellbook> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
            final Root<Spellbook> root = criteriaQuery.from(this.persistentClass);
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            final TypedQuery<Spellbook> query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
            result = query.getSingleResult();
            result.getSpells().size();
            result.getWizards().size();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
