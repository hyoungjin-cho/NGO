package com.summitworks.ngo.entities;

import java.io.Serializable;
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
import com.summitworks.ngo.utils.Formatter;

@Entity
@Table(name = "events")
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="event_name")
	private String eventName;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private EventCategory category;
	
	@Column(name = "start_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTimestamp;
	
	@Column(name = "end_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTimestamp;
	
	private String location;
	
	private boolean registrable;
	
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

	public EventCategory getCategory() {
		return category;
	}

	public void setCategory(EventCategory category) {
		this.category = category;
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
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	

	public boolean isRegistrable() {
		return registrable;
	}

	public void setRegistrable(boolean registrable) {
		this.registrable = registrable;
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
	
	public String getStartDate() {
		return Formatter.getDate(startTimestamp);
	}
	
	public String getEndDate() {
		return Formatter.getDate(endTimestamp);	
	}
	
	public String getStartTime() {
		return Formatter.getTime(startTimestamp);
	}
	
	public String getEndTime() {
		return Formatter.getTime(endTimestamp);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		Event e = (Event) o;
		return Objects.equals(this.id, e.getId());
	}
	
	@Override
	public String toString() {
		return eventName;
	}
}
