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

class SuppliesTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Supplies supplies;
	
	
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
		supplies = em.find(Supplies.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		supplies = null;
	}

	@Test
	void test() {
		assertEquals(1, supplies.getId());
		assertEquals("rope", supplies.getName());
	}


}
