package com.summitworks.ngo.exceptions;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(Long id) {
		super("User Not Found With ID: " + id);
	}
}
