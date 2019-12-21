package com.project.setofskills.services;

import java.util.List;

import com.project.setofskills.entities.Achiever;

public interface AchieverService {

	Achiever findByUserName(String username);

	List<Achiever> index();

	Achiever findByAchieverId(Integer id);

}
