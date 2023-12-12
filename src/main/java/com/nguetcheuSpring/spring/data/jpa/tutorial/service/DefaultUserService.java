package com.nguetcheuSpring.spring.data.jpa.tutorial.service;

import com.nguetcheuSpring.spring.data.jpa.tutorial.DTO.UserRegisteredDTO;
import com.nguetcheuSpring.spring.data.jpa.tutorial.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DefaultUserService extends UserDetailsService {

	User save(UserRegisteredDTO userRegisteredDTO);
	
}
