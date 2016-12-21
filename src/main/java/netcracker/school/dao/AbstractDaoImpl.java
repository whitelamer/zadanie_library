package netcracker.school.dao;

import netcracker.school.models.LibraryEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractDaoImpl<T extends LibraryEntity> implements AbstractDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> type;

    public AbstractDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(T object) {
        entityManager.persist(object);
        return object;
    }

    @Override
    public void update(T object) {
        entityManager.merge(object);
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery( "from "+type.getSimpleName() ).getResultList();
    }
}
