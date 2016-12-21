package netcracker.school.dao;

import netcracker.school.models.Book;
import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;

import java.util.List;

public interface LibraryDAO extends AbstractDao<Library> {
    List<Library> getActiveBookList(ReaderPassport reader);

    List<Library> getActiveBookList(Book book);
}
