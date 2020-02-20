package com.project.setofskills.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.setofskills.entities.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

	
	@Query(value="SELECT a FROM Achievement a JOIN FETCH a.achiever WHERE a.achiever.id = :id")
	List <Achievement> findAchievementsByAchieverId(@Param("id")Integer id);
  }
