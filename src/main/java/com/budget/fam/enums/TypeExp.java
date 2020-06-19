package com.budget.fam.enums;

public enum TypeExp {

	WANTS("Wants"),
	NEEDS("Needs"),
	SAVINGS("Savings");
	
	private final String displayItem;
	
	private TypeExp(String displayItem) {
		this.displayItem = displayItem;
	}
	
	public String getDisplayItem() {
		return displayItem;
	}
}
