package com.nationwide.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.nationwide.enums.ConservationStatus;

@Entity
public class CurrentSpecies {
	@Id
	@GeneratedValue
	private Integer speciesId;
	private String speciesName;
	private String scientificName;
	private String location;
	private Integer population;
	@Enumerated(EnumType.STRING)
	private ConservationStatus conservationStatus;
	
	public CurrentSpecies(){
	}

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public ConservationStatus getConservationStatus() {
		return conservationStatus;
	}

	public void setConservationStatus(ConservationStatus conservationStatus) {
		this.conservationStatus = conservationStatus;
	}
	
}
