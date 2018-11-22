package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

public class CKAccountUpdatedConfirmationPage extends AccountUpdateConfirmationPage{
	
	/**
	 * Method to verify the title of Calvin Klein account update confirmation page
	 */
	@Override
	public void verifyPageTitle() {
		String text = promptHeader.getText();
		assertThat(text).as("Account Update Confirmation Page Title").isEqualTo("Your personal details have been updated.");	
	}
	
}