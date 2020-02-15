package com.project.setofskills.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.setofskills.entities.Skill;
import com.project.setofskills.services.SkillService;


@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http:localhost:8099"})
public class SkillController {

	@Autowired
	private SkillService skillserv;
	
	@GetMapping("skills")
	public List<Skill> index(Principal principal) {
		return skillserv.index();
	}
	
	@GetMapping("skills/{id}")
	public Skill show(@PathVariable("id") int id, HttpServletResponse resp, Principal principal) {
		Skill skill = skillserv.show(id);
		if (skill != null) {
			resp.setStatus(200);
		} else {
			resp.setStatus(404);
		}
		
		return skill;
		
	}
	
	@PostMapping("skills")
	public Skill createSkill(@RequestBody Skill skill, HttpServletResponse resp, HttpServletRequest req, Principal principal) {
		Skill newSkill = null;
		
		try {
			newSkill = skillserv.create(skill);
			StringBuffer url = req.getRequestURL();
			url.append("/" + newSkill.getId());
			resp.setStatus(201);
			resp.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
		}
		
		return newSkill;
		
	}

}
