package com.summitworks.ngo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Regular")
public class RegularUser extends User {

	@OneToMany(mappedBy = "RegularUser", cascade= CascadeType.ALL, orphanRemoval = true)
	private Set<Registration> registeredEvents = new HashSet<>();

	public Set<Registration> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Registration> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}
	
	public void registerEvent(Registration r) {
		registeredEvents.add(r);
	}
	
}
