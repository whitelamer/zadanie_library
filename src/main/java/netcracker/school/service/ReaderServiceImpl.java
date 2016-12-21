package netcracker.school.service;

import netcracker.school.dao.BookDAO;
import netcracker.school.dao.ReaderDAO;
import netcracker.school.models.Book;
import netcracker.school.models.Category;
import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ReaderService")
//@EnableTransactionManagement
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    @Qualifier("ReaderDAO")
    private ReaderDAO DAO;

    @Transactional
    public ReaderPassport create(ReaderPassport object) {
        DAO.create(object);
        return object;
    }

    @Transactional
    public void update(ReaderPassport object) {
        DAO.update(object);
    }

    @Transactional
    public List<ReaderPassport> getAll() {
        return DAO.getAll();
    }

    @Transactional
    public List<ReaderPassport> getActive(User user){
        return DAO.getActive(user);
    }

    @Transactional
    public List<ReaderPassport> getByUser(User user) {
        return DAO.getByUser(user);
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
