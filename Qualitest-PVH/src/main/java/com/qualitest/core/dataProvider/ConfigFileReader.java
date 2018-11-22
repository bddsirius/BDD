package com.qualitest.core.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "src//test//resources//config//project.properties";
	
	public ConfigFileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path: " + propertyFilePath);
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath != null) {
			return testDataResourcePath;
		} else {
			throw new RuntimeException("Test Data Resource Path not specified in the project.properties file");
		}
	}
}
