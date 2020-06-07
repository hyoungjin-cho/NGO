package com.summitworks.ngo.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String eventName;
	private String description;
	private String category;
	private String startDate;
	private String endDate;
	private String starttime;
	private String endtime;
	private String location;
	private boolean allowRegistration;
	private String imageUrl;
	private Integer adultTicketPrice;
	private Integer childTicketPrice;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Event_Id")
	private Set<Registration> registration;

	public Set<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(Set<Registration> registration) {
		this.registration = registration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAllowRegistration() {
		return allowRegistration;
	}

	public void setAllowRegistration(boolean allowRegistration) {
		this.allowRegistration = allowRegistration;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getAdultTicketPrice() {
		return adultTicketPrice;
	}

	public void setAdultTicketPrice(Integer adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}

	public Integer getChildTicketPrice() {
		return childTicketPrice;
	}

	public void setChildTicketPrice(Integer childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
