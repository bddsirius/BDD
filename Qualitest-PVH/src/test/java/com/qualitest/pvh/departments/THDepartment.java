package com.qualitest.pvh.departments;

public enum THDepartment {
	WOMEN("WOMEN"), MEN("MEN"), KIDS("KIDS"),TOMMYNOW("TOMMYNOW"), TOMMY_JEANS("TOMMY JEANS"), TOMMY_ADAPTIVE("TOMMY ADAPTIVE"),
	SALE("SALE"), UNISEX("UNISEX");

	public final String name;

	THDepartment(String name) {
		this.name = name;
	}

}
