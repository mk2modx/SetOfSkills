package com.project.setofskills.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.setofskills.entities.Achievement;
import com.project.setofskills.entities.Achiever;
import com.project.setofskills.entities.Skill;
import com.project.setofskills.entities.User;
import com.project.setofskills.repositories.AchievementRepository;
import com.project.setofskills.repositories.AchieverRepository;
import com.project.setofskills.repositories.SkillRepository;
import com.project.setofskills.repositories.UserRepository;

@Service
public class AchieverServiceImpl implements AchieverService {

	@Autowired
	private AchieverRepository achieverepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private SkillRepository skillrepo;
	
	@Autowired
	private AchievementRepository achievementrepo;
	
	
	@Override
	public Achiever findByUserName(String username) {
		
		return achieverepo.findByUsername(username);
	}
	
	@Override
	public List<Achiever> index() {
		return achieverepo.findAll();
	}
	
	@Override
	public List<Achievement> indexAchievement() {
		return achievementrepo.findAll();
	}
	
	@Override
	public Achiever findByAchieverId(Integer id) {
		return achieverepo.findById(id).get();
	}
	
	@Override
	public Achiever create(Achiever achiever, User user) {
		
		Achiever newAchiever = null;
		
		if(achiever != null && user != null) {
			User newUser = userrepo.saveAndFlush(user);
			achiever.setUser(newUser);
			newAchiever = achieverepo.saveAndFlush(achiever);
		}
		return newAchiever;
		
	}
	
	@Override
	public Achiever update(Achiever achiever, User user, Integer studentId) {
		
		Optional<Achiever> managedAchiever = achieverepo.findById(studentId);
		if(managedAchiever.isPresent()) {
			Achiever actualAchiever = managedAchiever.get();
			actualAchiever.setAge(achiever.getAge());
			actualAchiever.setFirstName(achiever.getFirstName());
			actualAchiever.setLastName(achiever.getLastName());
			actualAchiever.setUser(user);
			actualAchiever.setImageLink(achiever.getImageLink());
			
			achieverepo.saveAndFlush(actualAchiever);
		}
		return achiever;
		
	}
	
	@Override
	public Achievement addAchievement(Integer achieverId, Integer skillId) {
		Achiever actualAchiever = null;
		Skill actualSkill = null;
		Achievement newAchievement = new Achievement();

		Optional<Achiever> managedAchiever = achieverepo.findById(achieverId);
		Optional<Skill> managedSkill = skillrepo.findById(skillId);
		
		if(managedAchiever.isPresent()) {
			actualAchiever = managedAchiever.get();
			actualSkill = managedSkill.get();
			newAchievement.setAchiever(actualAchiever);
			newAchievement.setSkill(actualSkill);
			LocalDate addNow = LocalDate.now();
			newAchievement.setDateStarted(addNow);
			newAchievement = achievementrepo.saveAndFlush(newAchievement);
			
		}
		return newAchievement;
		
	}
}
