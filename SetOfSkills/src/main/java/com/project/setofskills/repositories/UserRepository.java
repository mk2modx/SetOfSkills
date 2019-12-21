package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.setofskills.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
}
