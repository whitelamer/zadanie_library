package netcracker.school.dao;

import netcracker.school.models.Book;
import org.springframework.stereotype.Repository;

@Repository("BookDAO")
public class BookDaoImpl extends AbstractDaoImpl<Book> implements BookDAO {
}
