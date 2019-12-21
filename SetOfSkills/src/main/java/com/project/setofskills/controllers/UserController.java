package com.project.setofskills.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.setofskills.entities.User;
import com.project.setofskills.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http:localhost:8099" })
public class UserController {

	@Autowired
	private UserService serv;
	
	@GetMapping("users")
	public List<User> index(Principal principal) {
		return serv.index();
	}
}
