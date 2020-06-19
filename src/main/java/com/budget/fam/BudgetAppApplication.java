package com.budget.fam;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.budget.fam.dao.ExpenseRepository;
//import com.budget.fam.dao.IncomeRepository;
//import com.budget.fam.dao.SavingRepository;
//import com.budget.fam.domain.Expense;
//import com.budget.fam.domain.Income;
//import com.budget.fam.domain.Savings;
//import com.budget.fam.enums.TypeExp;
//import com.budget.fam.enums.TypeSav;

@SpringBootApplication
public class BudgetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetAppApplication.class, args);
	}

	
	/*
	@Autowired
	ExpenseRepository expRepo;
	
	@Autowired
	SavingRepository saveRepo;
	
	@Autowired
	IncomeRepository incRepo;
	
	@Bean
	CommandLineRunner running() {
		
		return args -> {
			
			TypeExp typE = TypeExp.NEEDS;
			TypeExp typEw = TypeExp.WANTS;
			TypeSav typeS = TypeSav.LIFEINSURANCE;
			TypeSav typeSk = TypeSav.KIDS;
			TypeSav typeSf = TypeSav.FAMILYSAVINGS;
			
			Expense exp = new Expense("Enovos" ,null, null, null, typE, 60);
			Expense exp1 = new Expense("Groceries" ,null, null, null, typE, 1250);
			Expense exp2 = new Expense("Reiff" ,null, null, null, typE, 120);
			Expense exp3 = new Expense("Internet" ,null, null, null, typEw, 60);
			Expense exp4 = new Expense("Cleaning Lady" ,null, null, null, typEw, 290);
			Expense exp5 = new Expense("Car" ,null, null, null, typE, 191);
			Expense exp6 = new Expense("Rent" ,null, null, null, typE, 950);
			Expense exp7 = new Expense("DKV" ,null, null, null, typEw, 154);
			
			expRepo.save(exp);
			expRepo.save(exp1);
			expRepo.save(exp2);
			expRepo.save(exp3);
			expRepo.save(exp4);
			expRepo.save(exp5);
			expRepo.save(exp6);
			expRepo.save(exp7);
			
			Savings sav1 = new Savings(typeS, 100, null, null);
			Savings sav2 = new Savings(typeSk, 50, null, null);
			Savings sav3 = new Savings(typeSf, 1000, null, null);
				
			saveRepo.save(sav1);
			saveRepo.save(sav2);
			saveRepo.save(sav3);
			
			Income inc = new Income("Salary", 6330.99, null, null, null);
			
			incRepo.save(inc);
			
		};
	}*/
}
