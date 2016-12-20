package netcracker.school.dao;

import netcracker.school.models.Book;
import netcracker.school.models.Category;

import java.util.List;

public interface BookDAO {
    public void addBook(Book book);

    public void saveBook(Book book);

    public List<Book> listBook();

    public void removeBook(Integer id);

    List<Category> listCategory();

    void addCategory(Category category);

    void saveCategory(Category category);
}
