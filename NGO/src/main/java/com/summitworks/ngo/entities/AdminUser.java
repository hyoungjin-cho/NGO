package com.summitworks.ngo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class AdminUser extends User{

	//TODO Add admin user's functionalities.
	//     Creation of n-numbers of regular users
	//     Manage events
}
