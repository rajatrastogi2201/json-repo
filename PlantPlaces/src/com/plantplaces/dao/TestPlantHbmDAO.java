package com.plantplaces.dao;
import java.util.List;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {
	
	private PlantHbmDAO plantHbmDAO;
	private List<Plant> fetchPlants;
	@Test
	public void verifyFetchByCommonName(){
		givenPlantDAOInstantiated();
		whenCommonNameisRedbud();
		thenVerifyResults();
	}

	private void thenVerifyResults() {
		// TODO Auto-generated method stub
		assertTrue(fetchPlants.size() > 0);
		for(Plant plant: fetchPlants) {
			assertEquals("RedBud", plant.getCommon());
		}
	}

	private void whenCommonNameisRedbud() {
		Plant p = new Plant();
		p.setCommon("RedBud");
		fetchPlants = plantHbmDAO.fetchPlants(p);
		
	}

	private void givenPlantDAOInstantiated() {
		 plantHbmDAO = new PlantHbmDAO();
		 
		
	}
}
