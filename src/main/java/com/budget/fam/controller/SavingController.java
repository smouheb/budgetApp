package com.budget.fam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budget.fam.dao.SavingRepository;
import com.budget.fam.domain.Savings;

@Controller
@RequestMapping("/saving")
public class SavingController {

	
	@Autowired
	SavingRepository savRepo;
	
	@GetMapping("/new-saving")
	public String createSaving(Model model, Savings saving) {

		model.addAttribute("formData", saving);
		
		return "savings/saving";
			
	}
	
	@PostMapping("/save-saving")
	public String saveSaving(Savings saving) {
	
		savRepo.save(saving);
		
		return "redirect:/saving/new-saving";
	}
	
	@GetMapping("/mgmt-saving")
	public String listOfSavings(Model model, Savings saving) {
		
		List<Savings>listOfSavings = savRepo.findAll();
		
		model.addAttribute("list", listOfSavings);
		
		return "savings/savingMgmt";
	}
}
