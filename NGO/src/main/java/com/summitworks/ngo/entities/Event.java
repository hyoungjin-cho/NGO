package com.summitworks.ngo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.summitworks.ngo.enums.EventCategory;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="event_name")
	private String eventName;
	
	private String description;
	
	@Column(name ="event_category")
	@Enumerated(EnumType.STRING)
	private EventCategory eventCategory;
	
	@Column(name = "start_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTimestamp;
	
	@Column(name = "end_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTimestamp;
	
	private Address address;
	
	@Column(name = "is_registrable")
	private boolean isRegistrable;
	
	@Column(name = "image_url")
	private String imgUrl;
	
	@Column(name = "adult_price")
	private double adultPrice;
	
	@Column(name = "child_price")
	private double childPrice;
	
	@OneToMany(
			mappedBy = "event",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Registration> users = new HashSet<>();

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

	public EventCategory getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(EventCategory eventCategory) {
		this.eventCategory = eventCategory;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isRegistrable() {
		return isRegistrable;
	}

	public void setRegistrable(boolean isRegistrable) {
		this.isRegistrable = isRegistrable;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public double getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(double adultPrice) {
		this.adultPrice = adultPrice;
	}

	public double getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(double childPrice) {
		this.childPrice = childPrice;
	}

	public Set<Registration> getUsers() {
		return users;
	}

	public void setUsers(Set<Registration> users) {
		this.users = users;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		Event e = (Event) o;
		return Objects.equals(this.id, e.getId());
	}
}
