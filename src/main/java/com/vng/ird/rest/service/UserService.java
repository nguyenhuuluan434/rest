package com.vng.ird.rest.service;

import java.util.List;

import com.vng.ird.rest.model.User;

public interface UserService {

	List<User> findAllUsers();

	User findById(long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	boolean isUserExist(User user);

	void deleteAllUsers();

}