package netcracker.school.dao;

import netcracker.school.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */

@Repository
public class BookDAOImpl implements BookDAO {

//    @Autowired
//    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        //sessionFactory.getCurrentSession().save(book);
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBook() {

        //return sessionFactory.getCurrentSession().createQuery("from Reader")
                //.list();
        return null;
    }

    public void removeBook(Integer id) {
        //Book book = (Book) sessionFactory.getCurrentSession().load(
        //        Book.class, id);
        //if (null != book) {
        //    sessionFactory.getCurrentSession().delete(book);
        //}

    }
}
