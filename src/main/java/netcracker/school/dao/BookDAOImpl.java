package netcracker.school.dao;

import netcracker.school.models.Book;
import netcracker.school.models.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class BookDAOImpl implements BookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addBook(Book book) {
        entityManager.persist( book );
        //sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void saveBook(Book book) {
        entityManager.merge( book );
        //sessionFactory.getCurrentSession().update(book);
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBook() {
        return entityManager.createQuery( "from Book " ).getResultList();
//        return sessionFactory.getCurrentSession().createQuery("from Book ")
//                .list();
    }

    public void removeBook(Integer id) {
//      Book entity = getById( id );
//      delete( entity );
        //entityManager.remove( entity );
    }

    @Override
    public List<Category> listCategory() {
        return entityManager.createQuery( "from Category" ).getResultList();
    }

    @Override
    public void addCategory(Category category) {
        entityManager.persist( category );
    }

    @Override
    public void saveCategory(Category category) {
        entityManager.merge( category );
    }
}
