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

class AchievementTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Achievement achievement;
	

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
		achievement = em.find(Achievement.class, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		achievement = null;
	}

	@Test
	void test() {
		assertEquals(4, achievement.getId());
		assertEquals(6, achievement.getSkillId());
		assertEquals(2, achievement.getAchieverId());
	}

}
