package com.summitworks.ngo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
	
	public static String getDate(Date date) {
		return DATE_FORMAT.format(date);
	}
	
	public static String getTime(Date date) {
		return TIME_FORMAT.format(date);
	}
}
