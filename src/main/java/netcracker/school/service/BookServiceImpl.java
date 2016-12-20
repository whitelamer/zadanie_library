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
public class BookServiceImpl extends GenericServiceImpl<Book> implements BookService{

    @Autowired
    private BookDAO DAO;

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
