package demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapid.j2ee.framework.core.exception.ApplicationException;
import com.rapid.j2ee.framework.core.exception.ApplicationRollbackException;
import com.rapid.j2ee.framework.mvc.constants.OperationResult;
import com.rapid.j2ee.framework.mvc.constants.OperationResultConstants;
import com.rapid.j2ee.framework.orm.medium.MediumSessionMapperOperations;

import demo.bean.User;
import demo.dao.UserDao;

@Service
@Transactional(noRollbackFor = ApplicationException.class, value = "odm_service")
public class UserServiceImpl implements UserService {

	// public List<User> userList = getAllUsers();

	public User login(User user) {
		return userDao.login(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public void addUser(String userName) {

		User user = new User();

		user.setUserName(userName);

		mediumSessionMapper.insert(user);

	}

	public void deleteUser(String userName) throws Exception {

		throw new IOException();

		// userDao.deleteUser(userName);
	}

	public void deleteAll() {
		userDao.deleteAll();
	}

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("Odm_SessionMapper")
	private MediumSessionMapperOperations mediumSessionMapper;

}
