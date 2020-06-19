package com.budget.fam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.budget.fam.domain.Expense;
import com.budget.fam.enums.TypeExp;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{

	List<Expense> findAll();
	
	@Query(value = "select e from Expense e where typeExpense = ?1")
	List<Expense> findByStatus(TypeExp status1 );
}
