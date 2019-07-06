package com.plantplaces.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class AddPlant {
	
	final static Logger logger = Logger.getLogger(AddPlant.class);
	@Inject
	private Plant plant;
	
	@Inject
	private IPlantService plantService;
	public String execute() {
		logger.info("Entering the execute method");
		String returnValue = "success";
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		try {
			plantService.save(plant);
			logger.info("Save successful " + plant.toString());
			// get faces context
			//FacesContext currentInstance = FacesContext.getCurrentInstance();
			FacesMessage fn = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Saved");
			currentInstance.addMessage(null, fn);
		} catch (Exception e) {
			logger.error("Error while saving plant. Message " + e.getMessage());
			e.printStackTrace();
			FacesMessage fn = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "Plant Not Saved");
			currentInstance.addMessage(null, fn);
			returnValue = "fail";
		}
		return returnValue;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public IPlantService getPlantService() {
		return plantService;
	}
	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}
}
