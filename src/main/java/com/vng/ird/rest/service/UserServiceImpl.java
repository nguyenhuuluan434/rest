package com.vng.ird.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.vng.ird.rest.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	static {
		users = populateDummyUsers();
	}

	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
		users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
		return users;
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#findAllUsers()
	 */
	public List<User> findAllUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#findById(long)
	 */
	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#findByName(java.lang.String)
	 */
	public User findByName(String name) {
		for (User user : users) {
			if (user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#saveUser(com.vng.ird.rest.model.User)
	 */
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#updateUser(com.vng.ird.rest.model.User)
	 */
	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#deleteUserById(long)
	 */
	public void deleteUserById(long id) {

		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#isUserExist(com.vng.ird.rest.model.User)
	 */
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}

	/* (non-Javadoc)
	 * @see com.vng.ird.rest.service.UserService#deleteAllUsers()
	 */
	public void deleteAllUsers() {
		users.clear();
	}
}
