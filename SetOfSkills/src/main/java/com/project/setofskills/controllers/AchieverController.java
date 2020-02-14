package com.project.setofskills.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.setofskills.entities.Achiever;
import com.project.setofskills.entities.AchieverCreate;
import com.project.setofskills.entities.User;
import com.project.setofskills.services.AchieverService;
import com.project.setofskills.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:8099" })
public class AchieverController {
	@Autowired
	private AchieverService achieserv;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserService userv;
	
	
	
	// A C H I E V E R S

	@GetMapping("achievers")
	public List<Achiever> index() {
		return achieserv.index();
	}

	@GetMapping("achievers/{id}")
	public Achiever getAchieverById(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		Achiever achiever = achieserv.findByAchieverId(id);
		if (achiever != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		return achiever;

	}
	
	@PostMapping("achievers/{uid}")
	public AchieverCreate createAchiever(@PathVariable("uid") int userId,@RequestBody AchieverCreate ac, HttpServletResponse resp, 
			HttpServletRequest req, Principal principal ) {
				Achiever created = null;
						
				Achiever achiever = new Achiever();
				
				User user = userv.findById(userId);
				
				achiever.setAge(ac.getAge());
				achiever.setFirstName(ac.getFirstName());
				achiever.setLastName(ac.getLastName());
				achiever.setImageLink(ac.getImageLink());
				
				
				
				try {
					created = achieserv.create(achiever, user);
					StringBuffer url = req.getRequestURL();
					url.append("/" + created.getId());
					resp.setStatus(201);
					resp.setHeader("Location", url.toString());
				} catch (Exception e) {
					System.err.println(e);
					resp.setStatus(400);
				}
				
		return ac;

	}

	@PutMapping("achievers/{aid}")
	public AchieverCreate updateAchiever(@PathVariable("aid") int achieverId, @RequestBody AchieverCreate ac,HttpServletResponse resp, 
			HttpServletRequest req, Principal principal ) {
		Achiever updated = null;
				
		Achiever achiever = new Achiever();
		User user = new User();
		
		achiever.setAge(ac.getAge());
		achiever.setFirstName(ac.getFirstName());
		achiever.setLastName(ac.getLastName());
		achiever.setImageLink(ac.getImageLink());
		
		user.setEnabled(ac.isEnabled());
		user.setPassword(encoder.encode(ac.getPassword()));
		user.setRole("USER");
		user.setUsername(ac.getUsername());
		user.setEmail(ac.getEmail());
		
		try {
			updated = achieserv.update(achiever, user, achieverId);
			if (updated != null) {
				resp.setStatus(200);
			} else {
				resp.setStatus(404);
			}

		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
		}
		
return ac;

}
	
	
}
