package com.nationwide.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.entity.CurrentSpecies;
import com.nationwide.entity.Id;
import com.nationwide.repositories.CurrentSpeciesRepo;

@RestController
@RequestMapping("currentSpecies")
public class CurrentSpeciesService {
	@Autowired
	private CurrentSpeciesRepo currentSpeciesRepo;
	

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ArrayList<CurrentSpecies> getCurrentSpecies() {
		ArrayList<CurrentSpecies> currentSpecies = currentSpeciesRepo.findAll();
		return currentSpecies;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{id}")
	public @ResponseBody CurrentSpecies getCurrentSpeciesById(@PathVariable int id) {
		CurrentSpecies currentSpecies = currentSpeciesRepo.findById(id);
		return currentSpecies;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Integer postCurrentSpecies(@RequestBody CurrentSpecies currentSpecies) {
		CurrentSpecies cs = currentSpeciesRepo.saveAndFlush(currentSpecies);
		Integer id = cs.getSpeciesId();
		return id;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteCurrentSpecies(@RequestBody Id id) {
		currentSpeciesRepo.deleteById(id.getId());
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{id}")
	public void deleteCurrentSpecies(@PathVariable int id, @RequestBody CurrentSpecies currentSpecies) {
		CurrentSpecies update = currentSpeciesRepo.findById(id);
		for (Field f : CurrentSpecies.class.getDeclaredFields()) {
	        try {
				if (f.get(currentSpecies) != null) {
					switch(f.getName()) {
						case "speciesName" :
							update.setSpeciesName(currentSpecies.getSpeciesName());
							break;
						case "scientificName" :
							update.setScientificName(currentSpecies.getScientificName());
							break;
						case "location" :
							update.setLocation(currentSpecies.getLocation());
							break;
						case "population" :
							update.setPopulation(currentSpecies.getPopulation());
							break;
						case "conservationStatus" :
							update.setConservationStatus(currentSpecies.getConservationStatus());
							break;
						case "imageUrl" :
							update.setImageUrl(currentSpecies.getImageUrl());
							break;
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
	    }
		currentSpeciesRepo.save(update);
		
		
	}
}
