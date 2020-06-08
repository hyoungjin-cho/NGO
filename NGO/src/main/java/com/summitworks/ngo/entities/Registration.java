package com.summitworks.ngo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {
	
	@EmbeddedId
	private RegistrationID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventId")
	private Event event;
	
	private String firstname;
	private String lastname;
	private String email;
	private String contactNumber;
	private Address address;
	private int totalAdultQty;
	private int totalChildQty;
	
	public RegistrationID getId() {
		return id;
	}
	public void setId(RegistrationID id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getTotalAdultQty() {
		return totalAdultQty;
	}
	public void setTotalAdultQty(int totalAdultQty) {
		this.totalAdultQty = totalAdultQty;
	}
	public int getTotalChildQty() {
		return totalChildQty;
	}
	public void setTotalChildQty(int totalChildQty) {
		this.totalChildQty = totalChildQty;
	}
	
	
	
}
