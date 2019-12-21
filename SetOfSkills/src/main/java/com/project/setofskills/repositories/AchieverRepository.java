package com.project.setofskills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.setofskills.entities.Achiever;

public interface AchieverRepository extends JpaRepository<Achiever, Integer> {

	@Query(value="SELECT a FROM Achiever a JOIN FETCH a.user.username = :username")
	Achiever findByUsername(@Param("username")String username);

}
