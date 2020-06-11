package com.summitworks.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.entities.Registration;
import com.summitworks.ngo.entities.RegistrationNext;
import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.EventNotFoundException;
import com.summitworks.ngo.exceptions.UserNotFoundException;
import com.summitworks.ngo.repo.RegistrationRepoistory;
import com.summitworks.ngo.services.EventService;
import com.summitworks.ngo.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/registration/")
public class RegistrationController {

	@Autowired
	RegistrationRepoistory regisRepo;
	@Autowired
	EventService eventService;
	@Autowired
	UserService userService;
	
	Registration registration;
	
	@PostMapping("{event_id}")
	public String registrationForEvent(Model model, @PathVariable(name="event_id") Long event_id) throws EventNotFoundException {
		registration = new Registration();
		Event event=eventService.getEvent(event_id);
		registration.setEvent(event);
		model.addAttribute("registration", registration);
		return "registration";
	}

	@PostMapping("/next")
	public ModelAndView next(@ModelAttribute("registration") Registration registration) throws EventNotFoundException {
		this.registration = registration;
		System.out.println("hhhhhh " + registration.getEvent().getId());
		System.out.println("con" + registration.getContactNumber());

		Event e = eventService.getEvent(registration.getEvent().getId());
		double totalAdultAmount = 0;
		double totalChildAmount = 0;
		totalAdultAmount = registration.getTotalAdultQty() * e.getAdultPrice();
		totalChildAmount = registration.getTotalChildQty() * e.getChildPrice();
		ModelAndView model = new ModelAndView("next");
		RegistrationNext nextReg = new RegistrationNext();
		nextReg.setRegistration(registration);
		nextReg.setTotalAdultAmount(totalAdultAmount);
		nextReg.setTotalChildAmount(totalChildAmount);
		model.addObject("totalAdultAmount", totalAdultAmount);
		model.addObject("totalChildAmount", totalChildAmount);
		model.addObject("registrationNext", nextReg);
		//model.addObject("registrationId",registration.getId());

		return model;

	}
	@RequestMapping("/confirm")
	public String registrationConfirmed() throws UserNotFoundException, EventNotFoundException {
		System.out.println(registration.getContactNumber());
		//TODO: Need to set logged in user into registration. So that we can properly mapping on DB. 
		// but I don't know how to get logged in user information.
		//for now So im hard coding for testing purpose.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = userService.findByUserId(auth.getName()).get(0);

		System.out.println("user " + auth.getName() + u.getUserId());
		Event e = eventService.getEvent(registration.getEvent().getId());
		registration.setEvent(e);
		// hard code registration for testing purpose.
//		Registration testRegi = new Registration();
//		testRegi.setAddress("address test");
//		testRegi.setContactNumber("contact test");
//		testRegi.setEmail("test@test.com");
//		testRegi.setFirstname("test first name");
//		testRegi.setLastname("test last name");
//		testRegi.setTotalAdultQty(20);
//		testRegi.setTotalChildQty(10);
//		testRegi.setUser(u);
//		testRegi.setEvent(e);
		userService.registerEvent(u, registration);
		return "redirect:/";
	}
}
