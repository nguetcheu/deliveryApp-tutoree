package com.nguetcheuSpring.spring.data.jpa.tutorial.controller;


import com.nguetcheuSpring.spring.data.jpa.tutorial.DTO.UserRegisteredDTO;
import com.nguetcheuSpring.spring.data.jpa.tutorial.entity.User;
import com.nguetcheuSpring.spring.data.jpa.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/adminScreen")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "adminScreen";
    }

	@GetMapping("/goToStaff")
	public String displayStaff(Model model){
		model.addAttribute("user", new UserRegisteredDTO());
		return "staff";
	}
	
	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	
}
