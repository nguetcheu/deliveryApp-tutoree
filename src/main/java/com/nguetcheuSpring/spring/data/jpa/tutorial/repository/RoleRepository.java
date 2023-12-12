package com.nguetcheuSpring.spring.data.jpa.tutorial.repository;

import com.nguetcheuSpring.spring.data.jpa.tutorial.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRole(String name);
}
