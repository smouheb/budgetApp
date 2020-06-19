package com.budget.fam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.budget.fam.dao.ExpenseRepository;
import com.budget.fam.domain.Expense;


@Controller
@RequestMapping("/")
public class ExpenseController {

	@Autowired
	ExpenseRepository expRep;
	
	
	@GetMapping("/mgmt")
	public String listOfExpense(Model model) {
		
		List<Expense> expense = expRep.findAll();
		
		model.addAttribute("list",  expense);
		
		return "expenses/expenseMgmt";	
	}
	
	
	@GetMapping("/new")
	public String getEntry(Model model) {
		
		model.addAttribute("formData",  new Expense());
		
		return "expenses/expense";	
	}
	
	@PostMapping("/create")
	public String saveExpense(Model model, Expense expense) {
		
		expRep.save(expense);
		
		return "redirect:/new";
	}
	
	@GetMapping("/edit")
	public String editExpense(@RequestParam("id") Long id, Expense expense, Model model) {
		
		 Optional<Expense>expDb = expRep.findById(id);
		
		
		 model.addAttribute("formData", expDb.get());
		 
		return  "expenses/update_expense";
	}
	
	@PostMapping("/updateExpense/{id}")
	public String updateExpense(@PathVariable("id") Long id, Expense expense, Model model) {

		expRep.save(expense);
		
		List<Expense> exp = expRep.findAll();
		model.addAttribute("list",  exp);
		
		return "expenses/expenseMgmt";	
	}
	
	@GetMapping("/deleteExpense")
	public String deleteExpense(@RequestParam("id") Long id){
		
		expRep.deleteById(id);
		
		return "redirect:/mgmt";
	}
	

	
}
