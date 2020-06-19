package com.budget.fam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.budget.fam.dao.PeriodRepository;
import com.budget.fam.domain.Income;
import com.budget.fam.domain.Period;
import com.budget.fam.domain.Savings;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	PeriodRepository periodRepo;
	
	@GetMapping
	public String index(Model model) {
		
		List<Period> p = periodRepo.findByStatusActive();
		List<Income> inc = null;
		List<Savings> sav = null;
		double am = 0;
		double incomes = 0;
		
		for(Period i : p) {
			inc = i.getIncomes();
			sav = i.getSavings();
			
		}
		
		p.forEach((i)->{
			
			if( i.getIncomes().size() > 0) {
				
				List<Income> incoming = i.getIncomes();
			}
			
		});
				
		for(Income income : inc) {
			incomes =  income.getAmount() + 0.34;	
		}
		
		for(Savings saving : sav) {		
			am = saving.getAmount() + incomes;
		}
				
		System.out.println(am);
		
		//model.addAttribute("ListOfExpense", p);
		
		return "index";
	}
	
	@PostMapping("/save-per-period")
	public String savePerPeriod( Period period) {
		
		
		
		return "redirect:/";
	}
	
	
	
	//select only active period => done
	//attach to that period expenses and savings
	//attach an income as well
	//when a period is created some fixed expenses should be loaded
	
	
	
}
