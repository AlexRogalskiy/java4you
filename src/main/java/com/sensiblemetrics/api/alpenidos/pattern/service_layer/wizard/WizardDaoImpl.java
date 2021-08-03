package com.sensiblemetrics.api.alpenidos.pattern.service_layer.wizard;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.common.DaoBaseImpl;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.spellbook.Spellbook;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * WizardDao implementation.
 */
public class WizardDaoImpl extends DaoBaseImpl<Wizard> implements WizardDao {

    @Override
    public Wizard findByName(final String name) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        Wizard result = null;
        try {
            tx = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Wizard> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
            final Root<Wizard> root = criteriaQuery.from(this.persistentClass);
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            final TypedQuery<Wizard> query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
            result = query.getSingleResult();

            for (final Spellbook s : result.getSpellbooks()) {
                s.getSpells().size();
            }
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
