package com.qualitest.pvh.testDataTypes;

public class Account {
	public String brand;
	public String email;
	public String password;
	
	/**
	 * Constructor to assign provided value to account password record
	 * @param brand - Brand
	 * @param email - Email
	 * @param password - Password
	 */
	public Account(String brand, String email, String password) {
		this.brand = brand;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Method to read brand value
	 * @return - Brand
	 */
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * Method to read email value
	 * @return - Email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Method to read password value
	 * @return - Password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Method to set brand value
	 * @param brand - Brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Method to set email value
	 * @param email - Email Address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Method to set password value
	 * @param password - Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}