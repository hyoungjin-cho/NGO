package com.summitworks.ngo.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {
	
	@EmbeddedId
	private RegistrationID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("event_id")
	private Event event;
	
	private String firstname;
	private String lastname;
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@OneToOne(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, 
			mappedBy= "Registration")
	private Address address;
	
	@Column(name = "total_adult_quantity")
	private int totalAdultQty;
	
	@Column(name = "total_child_quantity")
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
	
	@Override
	public int hashCode() {
		return Objects.hash(user, event);
	}
	
}
