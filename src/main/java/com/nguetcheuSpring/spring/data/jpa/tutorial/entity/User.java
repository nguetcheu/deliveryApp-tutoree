package com.nguetcheuSpring.spring.data.jpa.tutorial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_role",
			joinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "id"), // foreign key for table user is name cust_id
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") // foreign key for table role is name role_id
	)
	Set<Role> roles = new HashSet<Role>(); // unique role for each user
	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Role role) {
		this.roles.add(role);
	}

	
	
	
}
