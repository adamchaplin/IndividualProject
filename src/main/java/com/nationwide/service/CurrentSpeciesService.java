package com.nationwide.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.entity.CurrentSpecies;
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
	

	public @ResponseBody ArrayList<CurrentSpecies> getCurrentSpeciesOrdered() {
		ArrayList<CurrentSpecies> currentSpecies = currentSpeciesRepo.findAll();
		Collections.sort(currentSpecies);
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
	
	@RequestMapping(method=RequestMethod.DELETE, path="/{id}")
	public void deleteCurrentSpecies(@PathVariable int id) {
		currentSpeciesRepo.deleteById(id);
	}
	
//	@RequestMapping(method=RequestMethod.PUT, path="/currentSpecies/{id}")
//	public void deleteCurrentSpecies(@PathVariable int id, @RequestBody CurrentSpecies currentSpecies) {
//		currentSpeciesRepo.updateById(id);
//	}
}
