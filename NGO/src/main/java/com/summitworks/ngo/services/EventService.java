package com.summitworks.ngo.services;

import java.util.List;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.exceptions.EventNotFoundException;

public interface EventService {
	
	List<Event> getAllEvents();
	Event getEvent(Long id) throws EventNotFoundException;
	Event save(Event e);
	void updateEvent(Event e) throws EventNotFoundException;
	void deleteEvent(Long id) throws EventNotFoundException;

}
