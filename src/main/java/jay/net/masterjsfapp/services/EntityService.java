package jay.net.masterjsfapp.services;

import jay.net.masterjsfapp.repository.CRUDApps;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public abstract class EntityService<T> implements CRUDApps<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public EntityService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T read(Object id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public List<T> search(String keyword) {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.name LIKE :keyword", entityClass)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(Object id) {
        T entity = read(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public List<T> executeQuery(String query, Object... params) {
        TypedQuery<T> q = entityManager.createQuery(query, entityClass);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        return q.getResultList();
    }


    @Override
    @Transactional
    public int executeUpdate(String query, Object... params) {
        Query q = entityManager.createQuery(query);
        for (int i = 0; i < params.length; i++) {
            q.setParameter(i + 1, params[i]);
        }
        return q.executeUpdate();
    }


    @Override
    public List<T> list() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    @Override
    public List<String> dropdown() {
        return entityManager.createQuery("SELECT e.name FROM " + entityClass.getSimpleName() + " e", String.class)
                .getResultList();
    }

    @Override
    public T lookUp(String fieldName, Object value) {
        List<T> result = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + fieldName + " = :value", entityClass)
                .setParameter("value", value)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
