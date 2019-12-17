package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.setofskills.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
