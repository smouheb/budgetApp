package com.budget.fam.enums;

public enum PeriodName {
	
	JANUARY("January"),
	FEBRUARY("February"),
	MARCH("March"),
	APRIL("April"),
	MAY("May"),
	JUNE("June"),
	JULY("July"),
	AUGUST("August"),
	SEPTEMBER("September"),
	OCTOBER("October"),
	NOVEMBER("November"),
	DECEMBER("December");
	
	private final String displayName;
	
	private PeriodName(String displayName) {
		
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		
		return displayName;
	}	
	
}
