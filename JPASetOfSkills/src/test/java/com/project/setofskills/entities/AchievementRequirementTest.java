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

class AchievementRequirementTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private AchievementRequirement achieveReq;
	

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
		achieveReq = em.find(AchievementRequirement.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		achieveReq = null;
	}

	@Test
	void test() {
	
		assertEquals(1, achieveReq.getId());
		assertEquals(1, achieveReq.getAchievement().getId());
		assertEquals(1, achieveReq.getSkillReqs().getId());
		
	}
}
