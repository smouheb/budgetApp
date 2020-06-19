package com.budget.fam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.budget.fam.dao.ExpenseRepository;
import com.budget.fam.dao.IncomeRepository;
import com.budget.fam.dao.PeriodRepository;
import com.budget.fam.dao.SavingRepository;
import com.budget.fam.domain.Expense;
import com.budget.fam.domain.Income;
import com.budget.fam.domain.Period;
import com.budget.fam.domain.Savings;

@Controller
@RequestMapping("/")
public class PeriodController {

	@Autowired
	PeriodRepository periodRep;
	
	@Autowired
	ExpenseRepository expRep;
	
	@Autowired
	IncomeRepository incRepo;
	
	@Autowired
	SavingRepository savRepo;
	
	
	@GetMapping("/new-period")
	public String createPeriod(Model model, Period period) {
						
		List<Expense> exp = expRep.findAll();
		
		List<Income> inc = incRepo.findAll();
		
		List<Savings> sav = savRepo.findAll();
		
		model.addAttribute("expense",exp);
		
		model.addAttribute("savings",sav);

		model.addAttribute("income",inc);

		model.addAttribute("period",period);
		
		inc.forEach((i)->System.out.println(i.getAmount()+" "+i.getName()));
		
		return "period/periods";
	}
	
	@PostMapping("/save-period")
	public String savePeriod(
						   Model model, 
					       Period period,
					       @RequestParam List<Long> expense,
					       @RequestParam List<Long> incomes,
					       @RequestParam List<Long> savings,
					       @RequestParam("sDate") String sDate,
					       @RequestParam("eDate") String eDate
					       
							) throws ParseException {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date startD = dateformat.parse(sDate);
		Date endD = dateformat.parse(eDate);
		
		period.setStartDate(startD);
		period.setEndDate(endD);
		
		period.getIncomes().forEach((i)->System.out.println(i.getName()));
				
		periodRep.save(period);
		
		
		Iterable<Expense> exp = expRep.findAllById(expense);
		
		Iterable<Savings> sav = savRepo.findAllById(savings);
		
		Iterable<Income> inc = incRepo.findAllById(incomes);
		
			
		exp.forEach( i -> {
					 i.setPeriod(period);
					 expRep.save(i);
				});
			
		sav.forEach(i-> {
					i.setPeriod(period); 
					savRepo.save(i);
				});
		
		inc.forEach(i-> {
					i.setPeriod(period);
					incRepo.save(i);						
				});
		
		return "redirect:/new-period";

	}
		
	@GetMapping("/delete-period")
	public String deletePeriod(Period period, @RequestParam("id") Long id) {
		
		periodRep.delete(period);
		
		return "redirect:/period-mgmt";
		
	}
	
	@GetMapping("/period-mgmt")
	public String listPeriod(Model model) {
		
		List<Period> lperio = periodRep.findAll();
		
		model.addAttribute("listOfPeriod", lperio);
		
		return "period/periodMgmt";
	}
		
}
