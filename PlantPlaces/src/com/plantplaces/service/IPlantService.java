package com.plantplaces.service;

import java.util.List;

import com.plantplaces.dto.Plant;

/**
 * 
 * IPlantService includes all business related functions for a Plant and related entities
 * @author Rajat
 *
 */
public interface IPlantService {
	/**
	 * Return a collection of Plant objects that contain the given filter text
	 * @param filter a substring that should be contained in returned filters
	 * @return a collection of matching filters
	 */
	public List<Plant> filterPlants(String filter);
	
	/**
	 * Save the plant and perform a validation check
	 * @param plant the plant we are persisting
	 * @throws Exception if unable to save
	 */
	void save(Plant plant) throws Exception;
	
	List<Plant> fetchPlants(Plant plant);
}
