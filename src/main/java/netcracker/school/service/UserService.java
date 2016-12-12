package netcracker.school.service;

import netcracker.school.user.User;

import java.util.List;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(Integer id);
}
