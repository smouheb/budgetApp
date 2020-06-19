package com.budget.fam.enums;

public enum TypeSav {

	KIDS("Kids"),
	LIFEINSURANCE("Life_Insurance"),
	FAMILYSAVINGS("Family_Savings");
	
	private final String displayItem;
	
	private TypeSav(String displayItem) {
		
		this.displayItem = displayItem;
	}
	
	public String getDisplayItem() {
		
		return displayItem;
	}
}
