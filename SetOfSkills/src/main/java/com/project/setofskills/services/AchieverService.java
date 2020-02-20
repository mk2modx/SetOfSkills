package com.project.setofskills.services;

import java.util.List;

import com.project.setofskills.entities.Achievement;
import com.project.setofskills.entities.Achiever;
import com.project.setofskills.entities.Skill;
import com.project.setofskills.entities.User;

public interface AchieverService {

	Achiever findByUserName(String username);

	List<Achiever> index();

	Achiever findByAchieverId(Integer id);

	Achiever create(Achiever achiever, User user);

	Achiever update(Achiever achiever, User user, Integer studentId);

	Achievement addAchievement(Integer achieverId, Integer skillId);

	List<Achievement> indexAchievement();

	List<Achievement> indexAchievementsByAchieverId(Integer achieverId);

}
