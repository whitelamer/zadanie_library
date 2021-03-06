package netcracker.school.controlers;

import netcracker.school.models.Book;
import netcracker.school.models.Category;
import netcracker.school.models.User;
import netcracker.school.service.BookService;
import netcracker.school.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    @Qualifier("BookService")
    private BookService bookService;

    @RequestMapping(value = "bookList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<Book> bookList() {
        return bookService.getAll();
    }

    @RequestMapping(value = "bookAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public Book bookAdd(@RequestBody Book book) {
        bookService.create(book);
        return book;
    }

    @RequestMapping(value = "bookEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Book bookEdit(@RequestBody Book book) {
        bookService.update(book);
        return book;
    }
}
