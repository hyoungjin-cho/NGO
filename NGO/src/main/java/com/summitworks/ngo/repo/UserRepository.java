package com.summitworks.ngo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.ngo.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	public List<User> findByEmail(String email);
	public List<User> findByUserId(String userId);


}
