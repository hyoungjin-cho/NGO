package com.summitworks.ngo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String role;
	private String userId;
	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL, orphanRemoval = true)
	private Set<Registration> registeredEvents = new HashSet<>();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Set<Registration> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Registration> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void registerEvent(Registration r) {
		registeredEvents.add(r);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		User u = (User) o;
		return this.email.equalsIgnoreCase(u.getEmail()) &&
				this.firstname.equalsIgnoreCase(u.getFirstname()) &&
				this.lastname.equalsIgnoreCase(u.getLastname()) &&
				this.password.equalsIgnoreCase(u.getPassword());	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	
	@Override
	public String toString() {
		return this.firstname;
	}
}
