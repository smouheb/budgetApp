package com.budget.fam.enums;

public enum Status {

	ACTIVE("Active"),
	INACTIVE("Inactive"),
	CLOSE("Close");
	
	private final String displayItem;
	
	private Status(String displayItem) {
		this.displayItem = displayItem;
	}
	
	public String getDisplayItem() {
		return displayItem;
	}
}
