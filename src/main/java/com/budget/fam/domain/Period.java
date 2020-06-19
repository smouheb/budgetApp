package com.budget.fam.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.budget.fam.enums.PeriodName;
import com.budget.fam.enums.Status;

@Entity
@Table(name = "period", schema = "public")
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "period_seq")
	@SequenceGenerator(name = "period_seq", sequenceName = "period_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PeriodName name;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Date startDate;
	
	private Date endDate;
		
	@OneToMany(mappedBy = "period" ,
			   cascade = {
					   		CascadeType.DETACH, 
					   		CascadeType.MERGE, 
					   		CascadeType.PERSIST, 
					   		CascadeType.REFRESH
					   	 }
	          )
	private List<Savings> savings;
	
	@OneToMany(mappedBy = "period" ,
			   cascade = {
					   		CascadeType.DETACH, 
					   		CascadeType.MERGE, 
					   		CascadeType.PERSIST, 
					   		CascadeType.REFRESH
					   	 }
	          )
	private List<Income> incomes;
	
	
	@OneToMany(mappedBy = "period" ,
			   cascade = {
					   		CascadeType.DETACH, 
					   		CascadeType.MERGE, 
					   		CascadeType.PERSIST, 
					   		CascadeType.REFRESH
					   	 }
	          )
	private List<Expense> expense;
	
	public Period() {
		
	}

	
	public Period(PeriodName name, Status status, Date startDate, Date endDate, List<Expense> expense) {
		super();
		this.name = name;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.expense = expense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeriodName getName() {
		return name;
	}

	public void setName(PeriodName name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}


	public List<Savings> getSavings() {
		return savings;
	}


	public void setSavings(List<Savings> savings) {
		this.savings = savings;
	}


	public List<Income> getIncomes() {
		return incomes;
	}


	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
	
	
	
}
