package com.summitworks.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.exceptions.UserNotFoundException;
import com.summitworks.ngo.services.UserService;

//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;



@Controller
@RequestMapping("/users/")
public class UserController {
	@Autowired
	UserService userService;
	 
	@GetMapping("management") 
	public String listUsers(Model model) {
		model.addAttribute("listUsers", userService.getAllUsers());
		return "userManagement";
	}

	@GetMapping("add")
	public String showAddUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}

	@PostMapping("add")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/users/management";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) throws UserNotFoundException{
		ModelAndView mav = new ModelAndView("editUser");
		User user = userService.getUser(id);
		mav.addObject("user", user);
		return mav;
	}
	
	@PostMapping("edit/{id}")
	public String saveEditUser(User user) throws UserNotFoundException{
	    userService.updateUser(user);
	    return "redirect:/users/management" ;
	}
	
	@GetMapping("delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) throws UserNotFoundException {
		userService.deleteUser(id);
		return "redirect:/users/management";
	}
	  @RequestMapping("about")
	    public String about() {
	        return "about";
	    }
	  
	  @RequestMapping("login")
	    public String login() {
	        return "login";
	    }
	  @RequestMapping("home")
	    public String home() {
	        return "userManagement";
	    }
}
