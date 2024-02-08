package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	User addUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	boolean deleteUser(Long id);
	boolean updateUser(Long id, User newUserDetails);

}
