package com.summitworks.ngo.services;

import java.util.List;

import com.summitworks.ngo.entities.Registration;
import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.UserNotFoundException;

public interface UserService {

	List<User> getAllUsers();
	public List<User> findByUserId(String userId) ;

	User getUser(Long id) throws UserNotFoundException;
	User save(User u);
	void updateUser(User u) throws UserNotFoundException;
	void deleteUser(Long id) throws UserNotFoundException;
	void registerEvent(User u, Registration r);
	void registerEventWithUserId(Long userId, Registration r) throws UserNotFoundException;

}
