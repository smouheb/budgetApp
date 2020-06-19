package com.budget.fam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.budget.fam.domain.Savings;

public interface SavingRepository extends CrudRepository<Savings, Long> {

	List<Savings>findAll();
}
