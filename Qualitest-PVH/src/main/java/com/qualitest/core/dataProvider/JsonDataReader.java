package com.qualitest.core.dataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.pvh.testDataTypes.Account;

public class JsonDataReader {
		
	private final String accountFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "accounts.json";
	
	private List<Account> accountList;
	
	public JsonDataReader() {
		accountList = getAccountPasswordData();
	}

	/**
	 * Method to read account password file data as list
	 * @return - Account Password as list
	 */
	private List<Account> getAccountPasswordData() {
		Gson gson = new Gson();
		try {
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(accountFilePath));
			JsonObject jObject = (JsonObject)obj;
			JsonArray jArray = (JsonArray) jObject.get("accounts");
			Account[] accountData = gson.fromJson(jArray, Account[].class);
			return Arrays.asList(accountData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Account Password test data file not found at path:" + accountFilePath);
		}
	}
	
	/**
	 * Method to get record from account password file based on brand and email
	 * @param brand - Brand
	 * @param email - Email
	 * @return - Account Password record
	 */
	public final Account getAccountPasswordByBrandAndEmail(String brand, String email) {
		Account record = null;
		for(Account ap : accountList) {
			if(ap.brand.equalsIgnoreCase(brand) && ap.email.equalsIgnoreCase(email)) {
				record = ap;
				break;
			}
		}
		return record;
	}

}