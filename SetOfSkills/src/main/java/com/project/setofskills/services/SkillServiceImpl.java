package com.project.setofskills.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.setofskills.entities.Skill;
import com.project.setofskills.repositories.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	
	
	@Autowired
	private SkillRepository skillrepo;
	
	@Override 
	public Skill create(Skill skill) {
		Skill newSkill = null;

		if(skill != null) {
			newSkill = skillrepo.saveAndFlush(skill);
		}
		
		return newSkill;
		
	}

	@Override
	public List<Skill> index() {
		return skillrepo.findAll();
	}

	
	
	
}
