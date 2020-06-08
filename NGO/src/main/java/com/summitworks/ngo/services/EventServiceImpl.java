package com.summitworks.ngo.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.exceptions.EventNotFoundException;
import com.summitworks.ngo.repo.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepo;
	
	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public Event getEvent(Long id) throws EventNotFoundException {
		try {
			return eventRepo.getOne(id);
		} catch(EntityNotFoundException e) {
			throw new EventNotFoundException(id);
		}
	}

	@Override
	public void updateEvent(Event e) throws EventNotFoundException {
		try {
			eventRepo.getOne(e.getId());
			eventRepo.save(e);
		} catch(EntityNotFoundException err) {
			throw new EventNotFoundException(e.getId());
		}
		
	}

	@Override
	public void deleteEvent(Long id) throws EventNotFoundException {
		try {
			eventRepo.deleteById(id);
		} catch(IllegalArgumentException e) {
			throw new EventNotFoundException(id);
		}
		
	}
	
	@Override
	public Event save(Event e) {
		return eventRepo.save(e);
	}

}
