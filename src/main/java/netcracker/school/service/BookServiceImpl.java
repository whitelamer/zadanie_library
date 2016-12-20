package netcracker.school.service;

import netcracker.school.dao.BookDAO;
import netcracker.school.models.Book;
import netcracker.school.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@EnableTransactionManagement
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Transactional
    public List<Book> listBook() {
        return bookDAO.listBook();
    }

    @Transactional
    public void removeBook(Integer id) {
        bookDAO.removeBook(id);
    }

    @Transactional
    public List<Category> listCategory() {
        return bookDAO.listCategory();
    }

    @Transactional
    public void addCategory(Category category) {
        bookDAO.addCategory(category);
    }

    @Transactional
    public void saveCategory(Category category) {
        bookDAO.saveCategory(category);
    }
}
