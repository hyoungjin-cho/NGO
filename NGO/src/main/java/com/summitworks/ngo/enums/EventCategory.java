package com.summitworks.ngo.enums;

public enum EventCategory {
	Conference("Conference"), 
	Seminar("Seminar"), 
	Presentation("Presentaion");

	private final String displayValue;
	
	private EventCategory(String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
