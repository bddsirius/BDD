package com.qualitest.pvh.departments;

public enum SpeedoDepartment {
	WOMEN("Women"),
	MEN("Men"),
	KIDS("Kids"),
	GOGGLES("Goggles"),
	ACESSORIES("Accessories"),
	SPEEDO_FIT("Speedo Fit"),
	OUTLET("Outlet")
	;
	
	public final String name;
	
	SpeedoDepartment(String name) {
		this.name = name();
	}
}
