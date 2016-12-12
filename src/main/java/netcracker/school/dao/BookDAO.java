package netcracker.school.dao;

import netcracker.school.book.Book;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */
public interface BookDAO {
    public void addBook(Book book);

    public List<Book> listBook();

    public void removeBook(Integer id);
}
