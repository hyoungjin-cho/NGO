package com.summitworks.ngo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.ngo.entities.Event;

public interface EventRepoistory extends JpaRepository<Event,Long>{

}
