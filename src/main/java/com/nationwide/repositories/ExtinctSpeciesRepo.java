package com.nationwide.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nationwide.entity.ExtinctSpecies;

@Repository
public interface ExtinctSpeciesRepo extends JpaRepository<ExtinctSpecies, Integer>{
	public ArrayList<ExtinctSpecies> findAll();
	public ExtinctSpecies findById(int id);
}