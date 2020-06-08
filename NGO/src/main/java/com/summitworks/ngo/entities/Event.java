package com.summitworks.ngo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String description;
	
	@Column(name ="event_category")
	@Enumerated(EnumType.STRING)
	private EventCategory eventCategory;
	
	@Column(name = "start_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTimestamp;
	
	@Column(name = "end_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private boolean isRegistrable;
	private String imgUrl;
	private double adultPrice;
	private double childPrice;
	
}
