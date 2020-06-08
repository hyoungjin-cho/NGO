package com.summitworks.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.summitworks.ngo.entities.User;
import com.summitworks.ngo.repo.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController {
	@Value("${spring.application.name}")
	String appName;
	@Autowired
	UserRepository userRepo;	 
	 
	@GetMapping("/userManagement")
	public String homePage(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "userManagement";
	}

	@RequestMapping("/addUser")
	public String showAddUserPage(Model model) {
		System.out.println("add user method");

		User user = new User();
		model.addAttribute("user", user);

		return "addUser";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		System.out.println("Sve of controller");
		System.out.println("id after edit"+user.getId());
		userRepo.save(user);

		return "redirect:/userManagement";
	}
	@RequestMapping(value = "/editSave/{id}", method = RequestMethod.POST)
	public String saveEditUser(User user){
		System.out.println("id after edit"+user.getId());
	    userRepo.save(user);
	    return "redirect:/userManagement" ;
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editUser");
		User user = userRepo.getOne(id);
		mav.addObject("user", user);
		
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		userRepo.deleteById(id);
		return "redirect:/userManagement";
	}
	  @RequestMapping("/about")
	    public String about() {
	        return "about";
	    }
	  
	  @RequestMapping("/login")
	    public String login() {
	        return "login";
	    }
	  @RequestMapping("/home")
	    public String home() {
	        return "userManagement";
	    }
}
