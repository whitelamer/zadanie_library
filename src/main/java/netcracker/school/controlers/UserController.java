package netcracker.school.controlers;

import netcracker.school.models.Library;
import netcracker.school.models.ReaderPassport;
import netcracker.school.models.UserDetails;
import netcracker.school.service.LibraryService;
import netcracker.school.service.ReaderService;
import netcracker.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "userDetails", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public netcracker.school.models.UserDetails userDetails() {
        netcracker.school.models.User user=userService.getUserByEmail(userService.getCurrentUserName());
        UserDetails details = new UserDetails();
        details.setUser(user);
        List<ReaderPassport> activePassport = readerService.getByUser(user);
        for (ReaderPassport reader:activePassport) {
            reader.setGetedBooks(libraryService.getActiveBookList(reader));
        }
        details.setActivePreaderPassports(activePassport);
        return details;
    }

    @RequestMapping(value = "userList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<netcracker.school.models.User> usersList() {
        return userService.listUser();
    }

    @RequestMapping(value = "userAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public netcracker.school.models.User usersAdd(@RequestBody netcracker.school.models.User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "userEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public netcracker.school.models.User usersEdit(@RequestBody netcracker.school.models.User user) {
        System.out.println(user);
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "readerList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<netcracker.school.models.ReaderPassport> readerList() {
        return readerService.getAll();
    }

    @RequestMapping(value = "readerAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public netcracker.school.models.ReaderPassport usersAdd(@RequestBody netcracker.school.models.ReaderPassport passport) {
        readerService.create(passport);
        return passport;
    }

    @RequestMapping(value = "readerEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public netcracker.school.models.ReaderPassport usersEdit(@RequestBody netcracker.school.models.ReaderPassport passport) {
        readerService.update(passport);
        return passport;
    }


    @RequestMapping(value = "takeBook", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public String takeBook(@RequestBody netcracker.school.models.Book book) {
        if(libraryService.isBookFree(book)) {
            netcracker.school.models.User user=userService.getUserByEmail(userService.getCurrentUserName());
            List<ReaderPassport> activePassport = readerService.getActive(user);
            if(activePassport.size() != 0){
                Library newRecord = new Library(activePassport.get(0).getId(),book.getId());
                libraryService.create(newRecord);
                return "{\"mess\":\"Book Taken\"}";
            }
            return "{\"mess\":\"Reader Passport is not active\"}";
        }
        return "{\"mess\":\"Error Book is busy\"}";
    }

    @RequestMapping(value = "returnBook", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
    public Library returnBook(@RequestBody netcracker.school.models.Library record) {
        record.setState(1);
        libraryService.update(record);

        return record;
    }
}
