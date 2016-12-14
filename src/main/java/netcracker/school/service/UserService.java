package netcracker.school.service;

import netcracker.school.models.User;

import java.util.List;

public interface UserService {

	public void addUser(User user);

	public User getUserByEmail(String email);

	public List<User> listUser();

	public void removeUser(Integer id);

	public String getCurrentUserName();
}
