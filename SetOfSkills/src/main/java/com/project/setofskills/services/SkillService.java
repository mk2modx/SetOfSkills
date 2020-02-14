package com.project.setofskills.services;

import java.util.List;

import com.project.setofskills.entities.Skill;

public interface SkillService {



	Skill create(Skill skill);

	List<Skill> index();

}
