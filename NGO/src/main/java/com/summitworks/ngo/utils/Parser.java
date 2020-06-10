package com.summitworks.ngo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {

	private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"); 
	public static Date parseTimestamp(String timestamp) {
		try {
			return DATE_TIME_FORMAT.parse(timestamp);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
