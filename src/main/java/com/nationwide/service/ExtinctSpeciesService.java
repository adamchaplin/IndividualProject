package com.nationwide.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.entity.ExtinctSpecies;
import com.nationwide.repositories.ExtinctSpeciesRepo;

@RestController
@RequestMapping("extinctSpecies")
public class ExtinctSpeciesService {
	@Autowired
	private ExtinctSpeciesRepo extinctSpeciesRepo;
	

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ArrayList<ExtinctSpecies> getExtinctSpecies() {
		ArrayList<ExtinctSpecies> extinctSpecies = extinctSpeciesRepo.findAll();
		return extinctSpecies;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{id}")
	public @ResponseBody ExtinctSpecies getExtinctSpeciesById(@PathVariable int id) {
		ExtinctSpecies extinctSpecies = extinctSpeciesRepo.findById(id);
		return extinctSpecies;
	}
}
