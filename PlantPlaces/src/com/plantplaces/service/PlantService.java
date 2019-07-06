package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

@Named
public class PlantService implements IPlantService {
	
	@Inject
	private IPlantDAO plantDAO;
	private List<Plant> allPlants;
	
	@Override
	public List<Plant> filterPlants(String filter) {
		if(allPlants == null) {
			allPlants = getPlantDAO().fetchPlants();
		}
		List<Plant> returnPlants = new ArrayList<Plant>();
		
		//filter the list
		for (Plant plant : allPlants) {
			if(plant.toString().contains(filter)) {
				returnPlants.add(plant);
			}
		}
		return returnPlants;
	}
	
	public void save(Plant plant) throws Exception {
		if(plant.getGenus() == null || plant.getGenus().isEmpty()) {
			throw new Exception("Genus required");
		}
		plantDAO.insert(plant);
	}

	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}
	

}
