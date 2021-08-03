package com.sensiblemetrics.api.alpenidos.pattern.service_layer.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sensiblemetrics.api.alpenidos.pattern.service_layer.utils.HibernateUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Base class for Dao implementations.
 *
 * @param <E>
 */
public abstract class DaoBaseImpl<E extends BaseEntity> implements Dao<E> {
    @SuppressWarnings("unchecked")
    protected Class<E> persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /*
     * Making this getSessionFactory() instead of getSession() so that it is the responsibility
     * of the caller to open as well as close the session (prevents potential resource leak).
     */
    protected SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    @Override
    public E find(final Long id) {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        E result = null;
        try {
            tx = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
            final Root<E> root = criteriaQuery.from(this.persistentClass);
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
            final TypedQuery<E> query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
            result = query.getSingleResult();
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

    @Override
    public void persist(final E entity) {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public E merge(final E entity) {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        E result = null;
        try {
            tx = session.beginTransaction();
            result = (E) session.merge(entity);
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

    @Override
    public void delete(final E entity) {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<E> findAll() {
        final Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<E> result = null;
        try {
            tx = session.beginTransaction();
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
            final TypedQuery<E> query = session.getEntityManagerFactory().createEntityManager().createQuery(criteriaQuery);
            result = query.getResultList();
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
