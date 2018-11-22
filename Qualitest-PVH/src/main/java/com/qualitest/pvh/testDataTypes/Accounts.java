package com.qualitest.pvh.testDataTypes;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
	
	List<Account> accounts = new ArrayList<>();
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account ap) {
		this.accounts.add(ap);
	}
}