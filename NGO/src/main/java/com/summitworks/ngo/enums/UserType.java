package com.summitworks.ngo.enums;

public enum UserType {
	Admin("Admin"), 
	Regular("Regular");
	
	private final String displayValue;
	
	private  UserType(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
