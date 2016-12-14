package netcracker.school.controlers;

import netcracker.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/userDetails", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET,headers="Accept=application/json")
    public netcracker.school.models.User userDetails() {
        return userService.getUserByEmail(userService.getCurrentUserName());
    }

    @RequestMapping(value = "/userList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET,headers="Accept=application/json")
    public List<netcracker.school.models.User> usersList() {
        return userService.listUser();
    }

    @RequestMapping(value = "/userAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST,headers="Accept=application/json")
    public netcracker.school.models.User usersList(@ModelAttribute("user") netcracker.school.models.User user, BindingResult result) {
        userService.addUser(user);
        return user;
    }
}
