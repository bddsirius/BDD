package com.qualitest.pvh.pages;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class ForgotPasswordPage extends BasePage {
	
	
	
	@FindBy(id="PasswordResetForm_FormInput_logonId_In")
	public BaseElement resetEmail;
	
	@FindBy(id="WC_PasswordResetForm_Link_2")
	public BaseElement submitResetEmail;
	
	@FindBy(xpath="//*[@id=\"myAccountBodyHeaderContent\"]/h2")
	public BaseElement confirmation;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordPage.class);
	
	
	public void inputResetEmail(String input) {
		resetEmail.type(input);
	}
	
	
	public void clickSubmitEmail() {
		submitResetEmail.click();
	}
	
	public void confirmResetPasswordEmailSent() {
		assertTrue("Not Confirmed", confirmation.getText().contains("THANK YOU"));
	}
	

}