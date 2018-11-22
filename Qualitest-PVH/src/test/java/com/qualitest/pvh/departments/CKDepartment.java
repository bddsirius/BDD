package com.qualitest.pvh.departments;

public enum CKDepartment {
	NYC("205W39NYC"), WOMEN("WOMEN"), MEN("MEN"), KIDS("KIDS"), UNDERWEAR("UNDERWEAR"), HOME("HOME"), SALE("SALE"),
	PROJECTS("PROJECTS");

	public final String name;

	private CKDepartment(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return name;
	}
	
}
