package netcracker.school.controlers;

import netcracker.school.models.Book;
import netcracker.school.models.Category;
import netcracker.school.models.User;
import netcracker.school.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "bookList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<Book> bookList() {
        return bookService.listBook();
    }

    @RequestMapping(value = "bookAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public Book bookAdd(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @RequestMapping(value = "bookEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Book bookEdit(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @RequestMapping(value = "categoryList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<Category> categoryList() {
        return bookService.listCategory();
    }

    @RequestMapping(value = "categoryAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public Category categoryAdd(@RequestBody Category category) {
        bookService.addCategory(category);
        return category;
    }

    @RequestMapping(value = "categoryEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Category categoryEdit(@RequestBody Category category) {
        bookService.saveCategory(category);
        return category;
    }
}
