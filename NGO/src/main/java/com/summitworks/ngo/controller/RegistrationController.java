package com.summitworks.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.entities.Registration;
import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.EventNotFoundException;
import com.summitworks.ngo.exceptions.UserNotFoundException;
import com.summitworks.ngo.repo.EventRepoistory;
import com.summitworks.ngo.repo.RegistrationRepoistory;
import com.summitworks.ngo.services.EventService;
import com.summitworks.ngo.services.UserService;

@Controller
@RequestMapping("/registration/")
public class RegistrationController {

	@Autowired
	RegistrationRepoistory regisRepo;
	@Autowired
	EventService eventService;
	@Autowired
	UserService userService;
	
	@GetMapping("{event_id}")
	public String registrationForEvent(Model model, @PathVariable(name="event_id") Long event_id) {
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		model.addAttribute("event_id", event_id);
		return "registration";
	}

	@PostMapping("{event_id}/next")
	public String next(Model model, @ModelAttribute("registration") Registration registration, @PathVariable(name="event_id") Long event_id) throws EventNotFoundException {
		Event e = eventService.getEvent(event_id);
		double totalAdultAmount = 0;
		double totalChildAmount = 0;
		totalAdultAmount = registration.getTotalAdultQty() * e.getAdultPrice();
		totalChildAmount = registration.getTotalChildQty() * e.getChildPrice();
		model.addAttribute("totalAdultAmount", totalAdultAmount);
		model.addAttribute("totalChildAmount", totalChildAmount);
		model.addAttribute("registration", registration);
		model.addAttribute("event_id", event_id);
		return "next";

	}
	@RequestMapping("{event_id}/confirm")
	public String registrationConfirmed(@ModelAttribute("registration") Registration registration, @PathVariable(name="event_id") Long event_id) throws UserNotFoundException, EventNotFoundException {
		
		//TODO: Need to set logged in user into registration. So that we can properly mapping on DB. 
		// but I don't know how to get logged in user information.
		//for now So im hard coding for testing purpose.
		User u = userService.getUser(3L);
		Event e = eventService.getEvent(8L);

		// hard code registration for testing purpose.
		Registration testRegi = new Registration();
		testRegi.setAddress("address test");
		testRegi.setContactNumber("contact test");
		testRegi.setEmail("test@test.com");
		testRegi.setFirstname("test first name");
		testRegi.setLastname("test last name");
		testRegi.setTotalAdultQty(20);
		testRegi.setTotalChildQty(10);
		testRegi.setUser(u);
		testRegi.setEvent(e);
		userService.registerEvent(u, testRegi);
		return "redirect:/events/";
	}
}
