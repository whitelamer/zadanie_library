package netcracker.school.service;

import netcracker.school.dao.BookDAO;
import netcracker.school.models.Book;
import netcracker.school.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("BookService")
//@EnableTransactionManagement
public class BookServiceImpl implements BookService{

    @Autowired
    @Qualifier("BookDAO")
    private BookDAO DAO;

    @Transactional
    public Book create(Book object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(Book object) {
        DAO.update(object);
    }

    @Transactional
    public List<Book> getAll() {
        return DAO.getAll();
    }

//    @Transactional
//    public void addBook(Book book) {
//        DAO.create(book);
//    }
//
//    @Transactional
//    public void saveBook(Book book) {
//        DAO.update(book);
//    }
//
//    @Transactional
//    public List<Book> listBook() {
//        return DAO.getAll();
//    }
//
//    @Transactional
//    public void removeBook(Integer id) {
//
//    }

//    @Transactional
//    public List<Category> listCategory() {
//        return bookDAO.listCategory();
//    }
//
//    @Transactional
//    public void addCategory(Category category) {
//        bookDAO.addCategory(category);
//    }
//
//    @Transactional
//    public void saveCategory(Category category) {
//        bookDAO.saveCategory(category);
//    }
}
