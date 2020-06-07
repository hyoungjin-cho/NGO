package com.summitworks.ngo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String address;
	private Integer adultTicketQty;
	private Integer childTicketQty;
	private boolean isRegistrationConfirmed;
	public boolean isRegistrationConfirmed() {
		return isRegistrationConfirmed;
	}
	public void setRegistrationConfirmed(boolean isRegistrationConfirmed) {
		this.isRegistrationConfirmed = isRegistrationConfirmed;
	}
	@ManyToOne
    private Event event;
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAdultTicketQty() {
		return adultTicketQty;
	}
	public void setAdultTicketQty(Integer adultTicketQty) {
		this.adultTicketQty = adultTicketQty;
	}
	public Integer getChildTicketQty() {
		return childTicketQty;
	}
	public void setChildTicketQty(Integer childTicketQty) {
		this.childTicketQty = childTicketQty;
	}
	
	

}
