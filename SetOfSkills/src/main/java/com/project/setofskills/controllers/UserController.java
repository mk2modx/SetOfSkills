package com.project.setofskills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.setofskills.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http:localhost:7050" })
public class UserController {

	@Autowired
	private UserService serv;
	
	
}
