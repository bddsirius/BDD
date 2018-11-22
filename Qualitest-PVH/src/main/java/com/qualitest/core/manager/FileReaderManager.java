package com.qualitest.core.manager;

import com.qualitest.core.dataProvider.ConfigFileReader;
import com.qualitest.core.dataProvider.JsonDataReader;
import com.qualitest.core.dataProvider.JsonDataWriter;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static JsonDataWriter jsonDataWriter;
	
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}
	
	public JsonDataReader getJsonDataReader() {
		return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
	
	public JsonDataWriter getJsonDataWriter() {
		return (jsonDataWriter == null) ? new JsonDataWriter() : jsonDataWriter;
	}
}
