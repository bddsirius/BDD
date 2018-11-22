package com.qualitest.core.util;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Project {

	public static String ENV_SYSTEM_PROP = "env";
	
	public static String DEFAULT_ENV = "pq1";
	
	public static final Logger Log = LoggerFactory.getLogger(Project.class);

	public static EnvConfig Env = ConfigFactory.create(EnvConfig.class);

	static {
		if (System.getProperty(ENV_SYSTEM_PROP) == null)
		{
			Log.warn("System property for execution enviornment configiration (" +ENV_SYSTEM_PROP + ") not set, using default of " + DEFAULT_ENV);
			System.setProperty(ENV_SYSTEM_PROP, DEFAULT_ENV);
			Env = ConfigFactory.create(EnvConfig.class);
		}
	}

	public static void beforeStep() {
		Log.info("before step");
	}
	
	public static void afterStep() {
		Log.info("after step");
	}
	
	public static void beforeTest() {
		Log.info("before test");
	}

	public static void afterTest() {
		Log.info("after test");
		
		Verify.pushSoftAssertions(); //just in cases
		
	}

}
