package com.summitworks.ngo.exceptions;

public class EventNotFoundException extends Exception {
	
	public EventNotFoundException(Long id) {
		super("Event Not Found With IDt: " + id);
	}

}
