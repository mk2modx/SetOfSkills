package com.project.setofskills.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillRequirementTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private SkillRequirement skillReq;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("skillsPU");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		skillReq = em.find(SkillRequirement.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		skillReq = null;
	}

	@Test
	void test() {
	
		assertEquals(2, skillReq.getId());
		assertEquals(2, skillReq.getRequirement().getId());
		assertEquals(1, skillReq.getSkill().getId());
		assertEquals(2, skillReq.getStepNumber());
		
	}

}
