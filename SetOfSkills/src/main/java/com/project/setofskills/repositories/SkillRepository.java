package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.setofskills.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
