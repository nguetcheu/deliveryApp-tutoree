package com.nguetcheuSpring.spring.data.jpa.tutorial.repository;

import com.nguetcheuSpring.spring.data.jpa.tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String emailId);
}
