package netcracker.school.service;

import netcracker.school.models.Book;
import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;

import java.util.List;

public interface LibraryService extends AbstractService<Library> {
    List<Library> getActiveBookList(ReaderPassport reader);

    boolean isBookFree(Book book);
}
