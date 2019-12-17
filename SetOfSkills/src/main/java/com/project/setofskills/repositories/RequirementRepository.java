package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.setofskills.entities.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Integer> {

}
