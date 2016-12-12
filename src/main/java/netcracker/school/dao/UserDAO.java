package netcracker.school.dao;

import netcracker.school.user.User;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */
public interface UserDAO {
    public void addUser(User user);

    public List<User> listUser();

    public void removeUser(Integer id);
}
