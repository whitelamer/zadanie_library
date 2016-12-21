package netcracker.school.service;

import netcracker.school.models.Book;
import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;

import java.util.List;


public interface ReaderService extends AbstractService<ReaderPassport> {
    List<ReaderPassport> getActive(User user);

    List<ReaderPassport> getByUser(User user);
//    public void addBook(Book book);
//
//    public void saveBook(Book book);
//
//    public List<Book> listBook();
//
//    List<Category> listCategory();
//
//    void addCategory(Category category);
//
//    void saveCategory(Category category);
}
