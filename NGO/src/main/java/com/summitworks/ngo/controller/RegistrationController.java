package com.summitworks.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.entities.Registration;
import com.summitworks.ngo.repo.EventRepoistory;
import com.summitworks.ngo.repo.RegistrationRepoistory;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationRepoistory regisRepo;
	@Autowired
	EventRepoistory eventRepo;
	@RequestMapping("/RegisterForEvent/{id}")
	public String registrationForEvent(Model model,@PathVariable(name="id") Long id) {

		Registration registration = new Registration();
		Event event=eventRepo.getOne(id);
		registration.setEvent(event);
		model.addAttribute("registration", registration);

		return "registration";
	}

	@RequestMapping("/next")
	public ModelAndView next(@ModelAttribute("registration") Registration registration) {

		// System.out.println("id after edit" + registration.getId());
		Event event=eventRepo.getOne(registration.getEvent().getId());
		regisRepo.save(registration);
		long totalAdultAmount=0;
		long totalChildAmount=0;
		if(null!=registration.getAdultTicketQty()) {
			totalAdultAmount=registration.getAdultTicketQty()*event.getAdultTicketPrice();
		}
		
		if(null!=registration.getChildTicketQty()) {
			totalChildAmount=registration.getChildTicketQty()*event.getChildTicketPrice();
		}
	
		ModelAndView mav = new ModelAndView("next");
		// Event event = eventRepo.getOne(id);
		mav.addObject("totalAdultAmount", totalAdultAmount);
		mav.addObject("totalChildAmount", totalChildAmount);
		mav.addObject("registrationId",registration.getId());
		return mav;

	}
	@RequestMapping("/ConfirmRegistration/{id}")
	public String registrationConfirmed(@PathVariable(name="id") Long id) {
		Registration registration=regisRepo.getOne(id);
		registration.setRegistrationConfirmed(true);
		regisRepo.save(registration);
		return "redirect:/";
	}
//	@RequestMapping(value="/ConfirmRegistration", method=RequestMethod.POST)
//	public String registrationConfirmed(Model model,@PathVariable(name="id") Long id, 
//	        @RequestParam(value="action", required=true) String action) {
//
//	    if (action.equals("confirm")) {
//	    	Registration registration=regisRepo.getOne(id);
//			registration.setRegistrationConfirmed(true);
//			regisRepo.save(registration);
//			return "redirect:/userView";  
//	    }
//
//	    if (action.equals("cancel")) {
//	       model.addAttribute("message","register again");
//	       return "message"+"redirect:/userView";  
//	    }
//	    return "redirect:/userView";  
//	}
}
