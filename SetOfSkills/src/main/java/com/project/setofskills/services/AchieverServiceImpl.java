package com.project.setofskills.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.setofskills.entities.Achiever;
import com.project.setofskills.repositories.AchieverRepository;
import com.project.setofskills.repositories.UserRepository;

@Service
public class AchieverServiceImpl implements AchieverService {

	@Autowired
	private AchieverRepository achieverepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Override
	public Achiever findByUserName(String username) {
		
		return achieverepo.findByUsername(username);
	}
	
	@Override
	public List<Achiever> index() {
		return achieverepo.findAll();
	}
	
	@Override
	public Achiever findByAchieverId(Integer id) {
		return achieverepo.findById(id).get();
	}
}
