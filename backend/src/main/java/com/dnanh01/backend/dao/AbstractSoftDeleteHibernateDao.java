package com.dnanh01.backend.dao;


import com.dnanh01.backend.dao.iface.common.SoftDeleteDao;
import com.dnanh01.backend.model.domain.BaseClazz;
import com.dnanh01.backend.exception.EntityOperationException;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public abstract class AbstractSoftDeleteHibernateDao<T extends BaseClazz> extends AbstractHibernateDao<T>
        implements SoftDeleteDao<T> {

    private final Class<T> entityClass;


    protected AbstractSoftDeleteHibernateDao(Class<T> entityClass) {
        super(entityClass);
        this.entityClass = entityClass;
    }


    @Override
    public void softDelete(UUID id) throws EntityOperationException {
        try {
            Session session = getCurrentSession();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                entity.setActive(false);
                entity.setDeletedAt(LocalDateTime.now());
                session.merge(entity);
            } else {
                throw new EntityOperationException("Entity not found with ID: " + id);
            }
        } catch (HibernateException e) {
            throw new EntityOperationException("Error during soft delete operation", e);
        }
    }

    /**
     * Description: Restores a soft-deleted entity with the given ID.
     * Sets the entity's active status to true and clears the deletedAt timestamp.
     *
     * @param id The UUID of the entity to be restored.
     * @throws EntityOperationException If there's an error during the restore
     *                                  operation.
     * @author DNAnh01[Do Nguyen Anh]
     */
    @SuppressWarnings("deprecation")
    @Override
    public void restoreFromSoftDelete(UUID id) throws EntityOperationException {
        try {
            Session session = getCurrentSession();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                entity.setActive(true);
                entity.setDeletedAt(null);
                session.update(entity);
            } else {
                throw new EntityOperationException("Entity not found with ID: " + id);
            }
        } catch (HibernateException e) {
            throw new EntityOperationException("Error during restore operation", e);
        }
    }

    /**
     * Description: Finds an entity by its ID, including soft-deleted entities.
     *
     * @param id The UUID of the entity to find.
     * @return An Optional containing the entity if found, or an empty Optional if
     *         not found.
     * @throws EntityOperationException If there's an error during the find
     *                                  operation.
     * @author DNAnh01[Do Nguyen Anh]
     */
    @Override
    public Optional<T> findByIdIncludingDeleted(UUID id) throws EntityOperationException {
        try {
            Session session = getCurrentSession();
            return Optional.ofNullable(session.get(entityClass, id));
        } catch (HibernateException e) {
            throw new EntityOperationException("Error during find operation", e);
        }
    }

    /**
     * Description: Finds all entities, including soft-deleted ones, with the given
     * filter parameters.
     *
     * @param filterParams A map of filter parameters to apply to the query.
     * @return A list of entities matching the filter criteria.
     * @throws EntityOperationException If there's an error during the find
     *                                  operation.
     * @author DNAnh01[Do Nguyen Anh]
     */
    @Override
    public List<T> findAllIncludingDeleted(Map<String, Object> filterParams) throws EntityOperationException {
        try {
            Session session = getCurrentSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);

            List<Predicate> predicates = createPredicates(cb, root, filterParams);
            cq.where(predicates.toArray(new Predicate[0]));

            return session.createQuery(cq).getResultList();
        } catch (HibernateException e) {
            throw new EntityOperationException("Error during find all operation", e);
        }
    }
    private List<Predicate> createPredicates(CriteriaBuilder cb, Root<T> root, Map<String, Object> filterParams) {
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, Object> entry : filterParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (root.get(key) != null) {
                predicates.add(cb.equal(root.get(key), value));
            }
        }
        return predicates;
    }
}