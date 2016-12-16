package netcracker.school.service;

import netcracker.school.dao.UserDAO;
import netcracker.school.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    public User getUserByEmail(String email) {
        if(email==null)return null;
        return userDAO.getUserByEmail(email);
    }

    @Transactional
    public List<User> listUser() {
         return userDAO.listUser();
    }

    @Transactional
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    }

    public String getCurrentUserName(){
        String userName = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth instanceof AnonymousAuthenticationToken){

            System.out.println("auth == Anonymous :"+auth);
            return null;
        }

        Object principal = auth.getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        }
        return principal.toString();
    }
}
