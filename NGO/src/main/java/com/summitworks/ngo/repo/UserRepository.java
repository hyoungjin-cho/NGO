package com.summitworks.ngo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.ngo.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
