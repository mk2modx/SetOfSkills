package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.setofskills.entities.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

}
