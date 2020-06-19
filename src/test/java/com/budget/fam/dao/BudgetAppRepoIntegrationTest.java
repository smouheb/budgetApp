package com.budget.fam.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.budget.fam.domain.Expense;
import com.budget.fam.enums.TypeExp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetAppRepoIntegrationTest {

	@Autowired
	ExpenseRepository expRepo;
	
	@Test
	public void ifExpenseSaved_ThenSuccess() {
		
		LocalDateTime dateTest =  LocalDateTime.now();
		Expense newExp = new Expense("TestAssert", dateTest, dateTest, null, TypeExp.NEEDS, 123.50);
		Expense newExp2 = new Expense("TestAssert2", dateTest, dateTest, null, TypeExp.NEEDS, 150.50);
		
		expRepo.save(newExp);
		expRepo.save(newExp2);
		
		assertEquals(2, expRepo.findAll().size());
	}
}
