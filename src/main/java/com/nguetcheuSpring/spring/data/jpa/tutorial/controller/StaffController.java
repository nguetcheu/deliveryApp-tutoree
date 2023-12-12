package com.nguetcheuSpring.spring.data.jpa.tutorial.controller;

import com.nguetcheuSpring.spring.data.jpa.tutorial.DTO.UserRegisteredDTO;
import com.nguetcheuSpring.spring.data.jpa.tutorial.service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private DefaultUserService userService;

    @PostMapping("/registrationStaff")
    public String addProduct(@ModelAttribute("user") UserRegisteredDTO userRegisteredDTO) {

        userService.save(userRegisteredDTO);
        return "redirect:/login";
    }
}
