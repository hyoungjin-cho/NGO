package com.summitworks.ngo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.authentication.AmazonClient;
import com.summitworks.ngo.entities.Event;
import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.EventNotFoundException;
import com.summitworks.ngo.repo.EventRepoistory;
import com.summitworks.ngo.services.EventService;
import com.summitworks.ngo.utils.Parser;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	AmazonClient amazonClient;

	@GetMapping("/events/management")
	public String listEvents(Model model) {
		model.addAttribute("listEvents", eventService.getAllEvents());
		return "eventManagement";
	}

	@GetMapping("/events/add")
	public String showAddEventPage(Model model) {
		Event event = new Event();
		model.addAttribute("event", event);
		return "addEvent";
	}

	@PostMapping("/events/add")
	public String saveEvent(@ModelAttribute("event") Event event, @RequestPart(value = "file") MultipartFile file, 
			@RequestPart(value ="startDate") String startTimestampString, @RequestPart(value="endDate") String endTimestampString ) {
		if (event.getId() == null || file!=null ) {
			String fileLocation = this.amazonClient.uploadFile(file);
			event.setImgUrl(fileLocation);
		}
		Date startTimestamp = Parser.parseTimestamp(startTimestampString);
		Date endTimestamp = Parser.parseTimestamp(endTimestampString);
		event.setStartTimestamp(startTimestamp);
		event.setEndTimestamp(endTimestamp);
		eventService.save(event);
		return "redirect:/events/management";
	}

	@GetMapping("/events/edit/{id}")
	public ModelAndView showEditEventPage(@PathVariable(name = "id") Long id) throws EventNotFoundException {
		ModelAndView mav = new ModelAndView("editEvent");
		Event event = eventService.getEvent(id);
		mav.addObject("event", event);
		return mav;
	}
	
	@PostMapping("/events/edit/{id}")
	public String saveEditEvent(Event event, @RequestPart(value = "startDate") String startTimestampString,
			@RequestPart(value="endDate") String endTimestampString) throws EventNotFoundException {
		Date startTimestamp = Parser.parseTimestamp(startTimestampString);
		Date endTimestamp = Parser.parseTimestamp(endTimestampString);
		event.setStartTimestamp(startTimestamp);
		event.setEndTimestamp(endTimestamp);
	    eventService.updateEvent(event);
	    return "redirect:/events/management" ;
	}
	@RequestMapping("/events/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) throws EventNotFoundException{
		eventService.deleteEvent(id);
		return "redirect:/events/management";
	}
	
	@GetMapping("/events/detail/{id}")
	public ModelAndView eventDetail(@PathVariable(name = "id") Long id) throws EventNotFoundException {
		ModelAndView mav = new ModelAndView("showEventDetail");
		Event event = eventService.getEvent(id);
		System.out.println(event.isRegistrable());
		mav.addObject("event", event);
		return mav;
	}

	@GetMapping("/")
	public String userViewHomePage(Model model) {
		model.addAttribute("listEvents", eventService.getAllEvents());
		return "userViewAllEvents";
	}

	
}
