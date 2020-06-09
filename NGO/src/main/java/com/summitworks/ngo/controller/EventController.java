package com.summitworks.ngo.controller;

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

@Controller
@RequestMapping("/events/")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	AmazonClient amazonClient;

	@GetMapping("/management")
	public String listEvents(Model model) {
		model.addAttribute("listEvents", eventService.getAllEvents());
		return "eventHome";
	}

	//@RequestMapping("/addEvent")
	@GetMapping("/add")
	public String showAddEventPage(Model model) {
		System.out.println("add event method");
		Event event = new Event();
		model.addAttribute("event", event);
		return "addEvent";
	}

	//@RequestMapping("/saveEvent")
	@PostMapping("/add")
	public String saveEvent(@ModelAttribute("event") Event event, @RequestPart(value = "file") MultipartFile file) {
		System.out.println("file " + file);
		System.out.println("Sve of controller");
		System.out.println("id after edit" + event.getId());
		if (event.getId() == null || file!=null ) {
			String fileLocation = this.amazonClient.uploadFile(file);
			event.setImgUrl(fileLocation);
		}
		eventService.save(event);

		return "redirect:/events/management";
	}

	//@RequestMapping("/edit/{id}")
	@GetMapping("/edit/{id}")
	public ModelAndView showEditEventPage(@PathVariable(name = "id") Long id) throws EventNotFoundException {
		ModelAndView mav = new ModelAndView("editEvent");
		Event event = eventService.getEvent(id);
		mav.addObject("event", event);
		return mav;
	}
	
	//@RequestMapping(value = "/editSaveEvent/{id}", method = RequestMethod.POST)
	@PutMapping("/edit/{id}")
	public String saveEditEvent(Event event) throws EventNotFoundException {
		System.out.println("id after edit"+event.getId());
	    eventService.updateEvent(event);
	    return "redirect:/events/management" ;
	}
	@RequestMapping("/delete/{id}")
	//@DeleteMapping("/deleteEvent/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) throws EventNotFoundException{
		eventService.deleteEvent(id);
		return "redirect:/events/management";
	}

	@GetMapping("")
	public String userViewHomePage(Model model) {
		model.addAttribute("listEvents", eventService.getAllEvents());
		return "userViewAllEvents";
	}

	@RequestMapping("/detail/{id}")
	public ModelAndView eventDetail(@PathVariable(name = "id") Long id) throws EventNotFoundException {
		ModelAndView mav = new ModelAndView("showEventDetail");
		Event event = eventService.getEvent(id);
		System.out.println(event.isRegistrable());
		mav.addObject("event", event);
		return mav;
	}
}
