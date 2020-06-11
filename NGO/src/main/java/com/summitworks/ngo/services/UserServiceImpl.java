package com.summitworks.ngo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summitworks.ngo.entities.Registration;
import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.UserNotFoundException;
import com.summitworks.ngo.repo.RegistrationRepoistory;
import com.summitworks.ngo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	RegistrationRepoistory regRepo;
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(Long id) throws UserNotFoundException {
		try {
			return userRepo.getOne(id);
		} catch(EntityNotFoundException e){
			throw new UserNotFoundException(id);
		}
	}
	
	@Override
	public List<User> findByUserId(String userId){
		System.out.println(userId);
			return userRepo.findByUserId(userId);
		
	}

	@Override
	public void updateUser(User u) throws UserNotFoundException{
		try {
			userRepo.getOne(u.getId());
			userRepo.save(u);
		} catch(EntityNotFoundException e) {
			throw new UserNotFoundException(u.getId());
		}
	}

	@Override
	public void deleteUser(Long id) throws UserNotFoundException {
		try {
			userRepo.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new UserNotFoundException(id);
		}	
	}

	@Override
	public User save(User u) {
		return userRepo.save(u);
	}

	@Override
	public void registerEvent(User u, Registration r) {
		u.registerEvent(r);
		r.setUser(u);
		
		regRepo.save(r);
	}
	
	@Override
	public void registerEventWithUserId(Long userId, Registration r) throws UserNotFoundException {
		User u = this.getUser(userId);
		registerEvent(u, r);
	}

}
