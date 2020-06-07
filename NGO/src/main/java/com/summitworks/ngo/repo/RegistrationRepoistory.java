package com.summitworks.ngo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.ngo.entities.Registration;

public interface RegistrationRepoistory extends JpaRepository<Registration,Long>{

}
