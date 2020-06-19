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

import com.budget.fam.enums.TypeSav;

@Entity
public class Savings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "savings_seq")
	@SequenceGenerator(name = "savings_seq", sequenceName = "savings_seq", allocationSize = 1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TypeSav typeSavings;
	
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Period period;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Savings() {
		
	}
	
	public Savings( TypeSav typeSavings, double amount, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.typeSavings = typeSavings;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeSav getTypeSavings() {
		return typeSavings;
	}

	public void setTypeSavings(TypeSav typeSavings) {
		this.typeSavings = typeSavings;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
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

}
