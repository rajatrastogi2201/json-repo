package com.plantplaces.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
@ManagedBean
@Scope("session")
public class SpecimenVO {
	
	private Plant plant;
	@Inject
	private Specimen specimen;
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}
	
	public String save(){
		return "SpecimenSaved";
		
	}
}
