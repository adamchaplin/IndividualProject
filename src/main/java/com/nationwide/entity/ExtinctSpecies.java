package com.nationwide.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExtinctSpecies {
	@Id
	private Integer speciesId;
	private String speciesName;
	private String scientificName;
	private String location;
	private Date dateExtinct;
	
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
	public Date getDateExtinct() {
		return dateExtinct;
	}
	public void setDateExtinct(Date dateExtinct) {
		this.dateExtinct = dateExtinct;
	}
	
	
}
