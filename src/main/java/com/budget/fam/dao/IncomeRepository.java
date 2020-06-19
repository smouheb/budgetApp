package com.budget.fam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budget.fam.domain.Income;

public interface IncomeRepository extends CrudRepository<Income, Long>{

	List<Income> findAll();
}
