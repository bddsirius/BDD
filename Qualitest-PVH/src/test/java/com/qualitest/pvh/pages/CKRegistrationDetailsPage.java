package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

public class CKRegistrationDetailsPage extends RegistrationDetailsPage{

	
	/**
	 * Method to verify title of Calvin Klein registration details page
	 */
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Registration Details Page Title").isEqualTo("Calvin Klein - Register");
	}
	

}