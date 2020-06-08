package com.summitworks.ngo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RegistrationID implements Serializable{

	@Column(name="user_id")
	private Long userID;
	
	@Column(name="event_id")
	private Long eventID;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		RegistrationID other = (RegistrationID) o;
		return Objects.equals(this.userID, other.userID) && 
				Objects.equals(this.eventID, other.eventID);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.userID, this.eventID);
	}
}
