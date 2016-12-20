package netcracker.school.service;

import netcracker.school.models.Book;
import netcracker.school.models.Category;

import java.util.List;


public interface BookService {
    public void addBook(Book book);

    public void saveBook(Book book);

    public List<Book> listBook();

    public void removeBook(Integer id);

    List<Category> listCategory();

    void addCategory(Category category);

    void saveCategory(Category category);
}
