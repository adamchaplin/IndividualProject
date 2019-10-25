package com.nationwide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nationwide.service.CurrentSpeciesService;

@Controller
public class EditController {
	@Autowired
	CurrentSpeciesService currentSpeciesService;
	
	@GetMapping("/edit")
    public String viewPage(Model model) {
		model.addAttribute("species", currentSpeciesService.getCurrentSpecies());
        return "edit";
    }

}
