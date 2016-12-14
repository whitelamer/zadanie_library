package netcracker.school.service;

import netcracker.school.models.User;
import netcracker.school.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
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
}
