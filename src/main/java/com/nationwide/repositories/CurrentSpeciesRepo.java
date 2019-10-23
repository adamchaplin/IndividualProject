package com.nationwide.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nationwide.entity.CurrentSpecies;



@Repository
public interface CurrentSpeciesRepo extends JpaRepository<CurrentSpecies, Integer>{
	public ArrayList<CurrentSpecies> findAll();
	public CurrentSpecies findById(int id);
}