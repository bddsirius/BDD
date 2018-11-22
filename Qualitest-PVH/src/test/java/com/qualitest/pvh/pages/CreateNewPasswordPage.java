package com.qualitest.pvh.pages;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class CreateNewPasswordPage extends BasePage {

	@FindBy(id = "WC_CreateNewPasswordForm_FormInput_NewPassword_In_CreateNewPasswordForm_1")
	private BaseElement newPassword;
	
	@FindBy(id = "WC_CreateNewPasswordForm_FormInput_VerifyPassword_In_CreateNewPasswordForm_1")
	private BaseElement confirmPassword;
	
	@FindBy(id = "WC_PasswordResetForm_Link_2")
	private BaseElement submitPassword;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CreateNewPasswordPage.class);
	
	public void enterPassword(String password) {
		LOGGER.info("Entering the new password with: "+password);
		newPassword.type(password);
		confirmPassword.type(password);
	}
	
	public void clickSubmit() {
		LOGGER.info("Clicking submit");
		submitPassword.click();
	}
	
	public void createNewPassword(String password) {
		enterPassword(password);
		clickSubmit();
	}
	
	public void createNewPasswordOnNewPasswordPage(String password) {
		LOGGER.info("Swithing to the next frame");
		ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs2.get(1));
	    createNewPassword(password);
	}
	
}
