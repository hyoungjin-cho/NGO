package com.summitworks.ngo.services;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.entities.RegularUser;

public interface RegularUserService {

	void registerEvent(RegularUser u, Event e);
}
