package com.summitworks.ngo.services;

import java.util.List;

import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.UserNotFoundException;

public interface UserService {

	List<User> getAllUsers();
	User getUser(Long id) throws UserNotFoundException;
	User save(User u);
	void updateUser(User u) throws UserNotFoundException;
	void deleteUser(Long id) throws UserNotFoundException;

}
