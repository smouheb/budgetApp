package com.budget.fam.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.budget.fam.enums.TypeExp;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
	@SequenceGenerator(name = "expense_seq", sequenceName = "expense_seq", allocationSize = 1)
	private Long id;
	
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Enumerated(EnumType.STRING)
	private TypeExp typeExpense;

	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Period period;
	
	public Expense() {
		
	
	}
	
	public Expense(String name, LocalDateTime createdAt, LocalDateTime updatedAt, Period period, TypeExp typeExpense, double amount) {
		super();
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.period = period;
		this.typeExpense  = typeExpense;
		this.amount = amount;
		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public TypeExp getTypeExpense() {
		return typeExpense;
	}

	public void setTypeExpense(TypeExp typeExpense) {
		this.typeExpense = typeExpense;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
}
