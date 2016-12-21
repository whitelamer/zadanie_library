package netcracker.school.service;

import netcracker.school.dao.LibraryDAO;
import netcracker.school.models.Book;
import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("LibraryService")
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    @Qualifier("LibraryDAO")
    private LibraryDAO DAO;

    @Transactional
    public Library create(Library object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(Library object) {
        DAO.update(object);
    }

    @Transactional
    public List<Library> getAll() {
        return DAO.getAll();
    }

    @Transactional
    public List<Library> getActiveBookList(ReaderPassport reader) {
        return DAO.getActiveBookList(reader);
    }

    @Transactional
    public boolean isBookFree(Book book) {
        return DAO.getActiveBookList(book).size() == 0;
    }
}
