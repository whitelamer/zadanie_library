package netcracker.school.controlers;

import netcracker.school.models.UserRole;
import netcracker.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 01.12.16.
 */
@RestController
public class UserRoleController {

//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserService userService;
//
//
//    @RequestMapping(value = "myRole", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
//    public Set<UserRole> myRole() {
//        Set<UserRole> role=userService.getUserByEmail(userService.getCurrentUserName()).getUserRoles();
//        return role;
//    }
//
//    @RequestMapping(value = "roleList", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
//    public List<netcracker.school.models.User> roleList() {
//        return roleService.listRoles();
//    }
//
//    @RequestMapping(value = "roleAdd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.POST)
//    public netcracker.school.models.UserRole roleAdd(@RequestBody netcracker.school.models.UserRole role) {
//        roleService.addRole(role);
//        return role;
//    }
//
//    @RequestMapping(value = "roleEdit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//    public netcracker.school.models.UserRole roleEdit(@RequestBody netcracker.school.models.UserRole role) {
//        roleService.saveRole(role);
//        return role;
//    }
}
