package netcracker.school.controlers;

import netcracker.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "userDetails", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public netcracker.school.models.User userDetails() {
        netcracker.school.models.User user=userService.getUserByEmail(userService.getCurrentUserName());
        return user;
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
}
