package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoPersonalInformationPage extends PersonalInformationPage {
	
	
	@FindBy(id="WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_firstName_1")
	private BaseElement firstName;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_NameEntryForm_FormInput_lastName_1")
	private BaseElement lastName;
	
	@FindBy(id="WC_UserRegistrationUpdateForm_FormInput_phoneNum_In_Register_1")
	private BaseElement phone;
	
	@FindBy(css="#Register > div.clearfix > div.button_footer_line.clearfix > #WC_UserRegistrationUpdateForm_links_1")
	private BaseElement update;
	
	protected void enterFirstName(String first) {
		firstName.type(first);
	}
	
	protected void enterLastName(String last) {
		lastName.type(last);
	}
	
	protected void enterPhone(String phoneNumber) {
		phone.type(phoneNumber);
	}
	private void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoPersonalInformationPage.class);
	
	public void enterFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 3) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		enterPhone(arr[2]);
		clickUpdate();
	}
	
	public void enterAddressAndSubmitThreeTimes(String guestFields) {
		enterFieldsAndSubmit(guestFields);
		sleep(2000);
		clickUpdate();
		sleep(2000);
		clickUpdate();
		sleep(2000);
	}
	
}
