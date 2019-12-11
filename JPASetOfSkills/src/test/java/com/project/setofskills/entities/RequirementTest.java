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

class RequirementTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Requirement req;
	

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
		req = em.find(Requirement.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		req = null;
	}

	@Test
	void test() {
	
		assertEquals(1, req.getId());
		assertEquals("Knot Req 1", req.getName());
		
	}
}
