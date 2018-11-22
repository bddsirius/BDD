package com.qualitest.core.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.pvh.testDataTypes.Account;
import com.qualitest.pvh.testDataTypes.Accounts;

public class JsonDataWriter {
	
	private final String accountFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "accounts.json";
	
	/**
	 * Method to update password for a provided brand and email in accountPassword file
	 * @param brand - Brand
	 * @param email - Email
	 * @param password - Password
	 * @return - true if update is completed, else false
	 */
	public boolean updateAccountPasswordData(String brand, String email, String password) {
		
		Gson gson = new Gson();
		BufferedReader bufferedReader = null;
		FileWriter writer = null;
		Account[] accountData = null;
		String jsonString = null;
		boolean flag = false;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(accountFilePath));
			accountData = gson.fromJson(bufferedReader, Account[].class);
			try {
				for(Account ap : accountData) {
					if(ap.brand.equalsIgnoreCase(brand) && ap.email.equalsIgnoreCase(email)) {
						ap.password = password;
						flag = true;
						break;
					}
				}
				if(flag) {
					jsonString = gson.toJson(accountData);
					writer = new FileWriter(accountFilePath);
					writer.write(jsonString);
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Account Password test data file not found at path:" + accountFilePath);
		} finally {
			try {
				if(bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	/**
	 * Method to add new record in accountPassword file
	 * @param brand - Brand
	 * @param email - Email
	 * @param password - Password
	 * @return - true if record is added, else false
	 */
	public boolean addAccountPasswordData(String brand, String email, String password) {
	
		Account acnPwd = new Account(brand, email, password);
		Gson gson = new Gson();
		FileWriter writer = null;
		boolean flag = true;
		Account ap = null;
		try {
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(accountFilePath));
			JsonObject jObject = (JsonObject)obj;
			JsonArray jArray = (JsonArray) jObject.get("accounts");
			Iterator<JsonElement> iterator = jArray.iterator();
			Accounts acn = new Accounts();
			while(iterator.hasNext()) {
				ap = gson.fromJson(iterator.next().toString(),Account.class);
				acn.addAccount(ap);
				if(ap.brand.equalsIgnoreCase(brand) && ap.email.equalsIgnoreCase(email)) {
					flag = false;
				}
			}
			if(flag) {
				try {
					writer = new FileWriter(accountFilePath);
					JsonWriter jw = new JsonWriter(writer);
					acn.addAccount(acnPwd);
					gson.toJson(acn,Accounts.class,jw);
					writer.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} catch (FileNotFoundException excp) {
			throw new RuntimeException("Account Password test data file not found at path:" + accountFilePath);
		}		
		return flag;
	}

}