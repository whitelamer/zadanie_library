package netcracker.school.controlers;

import netcracker.school.service.UserService;
import netcracker.school.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */
@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST,headers="Accept=application/json")
//    public String getCountries()    {
//        Session session = userService.openSession();
//        List<User> listAccount = session.createQuery("from users as user").list();
//        System.out.println("listAccount "+listAccount);
//        return "hi";
//    }
}
