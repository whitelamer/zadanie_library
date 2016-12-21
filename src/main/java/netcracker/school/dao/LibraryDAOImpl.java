package netcracker.school.dao;

import netcracker.school.models.Book;
import netcracker.school.models.Category;
import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("LibraryDAO")
public class LibraryDAOImpl extends AbstractDaoImpl<Library> implements LibraryDAO {
    @Override
    public List<Library> getActiveBookList(ReaderPassport reader) {
        if(reader==null)return null;
        List<Library> results =
                entityManager.createNamedQuery(Library.NamedQuery.FIND_BY_PASSPORT_STATE, Library.class)
                        .setParameter("passport_id", reader.getId())
                        .getResultList();
        return results;
    }

    @Override
    public List<Library> getActiveBookList(Book book) {
        if(book==null)return null;
        List<Library> results =
                entityManager.createNamedQuery(Library.NamedQuery.FIND_BY_BOOK_STATE, Library.class)
                        .setParameter("book_id", book.getId())
                        .getResultList();
        return results;
    }
}
