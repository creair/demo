package demo.service;

import java.util.List;

import demo.bean.User;

public interface UserService {

	public User login(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();

	public void addUser(String userName);

	public void deleteUser(String userName) throws Exception;

	public void deleteAll();
}
