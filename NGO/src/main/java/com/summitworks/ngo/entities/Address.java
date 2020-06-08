package com.summitworks.ngo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String steet) {
		this.street = steet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return this.street.equalsIgnoreCase(address.getStreet()) &&
				this.city.equalsIgnoreCase(address.getCity()) &&
				this.state.equalsIgnoreCase(address.getState()) &&
				this.country.equalsIgnoreCase(address.getCountry()) &&
				this.zipCode.equals(address.zipCode);	
	}
}
