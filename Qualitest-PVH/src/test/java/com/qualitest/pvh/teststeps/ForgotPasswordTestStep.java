package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.GoogleActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ForgotPasswordTestStep { 
	
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	GoogleActor googleUser;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordTestStep.class);
	
	@And("^User navigates to forgot password page$")
	public void user_navigate_to_forgot_password() {
		LOGGER.info("Navigating to forgot password page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.goToForgotPassword();
                 break;
          case "TH":
                 thUser.goToForgotPassword();
                 break;
          case "SPEEDO":
        	  	 speedoUser.goToForgotPassword();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	@And("^User sends password reset link to (.*)$")
	public void user_sends_forgot_password_email(String email) {
		LOGGER.info("Sending reset password to email " + email+"...");
		String brand = Serenity.sessionVariableCalled("brand");
		Serenity.setSessionVariable("email").to(email);
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.sendResetPasswordEmail(email);
                 break;
          case "TH":
                 thUser.sendResetPasswordEmail(email);
                 break;
          case "SPEEDO":
        	  	 speedoUser.sendResetPasswordEmail(email);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@Then("^User should be able to confirm password reset was sent$")
		public void user_confirm_forgot_password_email_send() {
		LOGGER.info("Confirming email was sent...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.confirmResetEmailSent();
                 break;
          case "TH":
                 thUser.confirmResetEmailSent();
                 break;
          case "SPEEDO":
        	  	 speedoUser.confirmResetEmailSent();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
		}
	
	@And("^User navigates to email folder (.*)$")
	public void user_navigates_to_email_folder(String password) {
		LOGGER.info("Confirming email was sent in inbox by going to inbox...");
		String email = Serenity.sessionVariableCalled("email");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
        case "CKUS":
        case "CKCA": 
        	googleUser.goToInbox(email, password, 0);
        	   break;
        case "TH":
        	googleUser.goToInbox(email, password, 0);
               break;
        case "SPEEDO":
        	googleUser.goToInbox(email, password, 0);
      	  	 break;
        default:
               LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
        }
	}
	
	@When("^User should have email for password reset$")
	public void user_should_have_email_for_password_reset() {
		LOGGER.info("User is navigating to email...");
		googleUser.goToEmailAndClickHere();	
	}
	
	@And("^User should change password on new page (.*)$")
	public void user_should_change_password_on_new_page(String newPassword) {
		LOGGER.info("User is resetting password in new tab...");
		Serenity.setSessionVariable("newPassword").to(newPassword);
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
        case "CKUS":
        case "CKCA": 
        	ckUser.createNewPasswordOnNewPage(newPassword);
        	   break;
        case "TH":
            thUser.createNewPasswordOnNewPage(newPassword);
               break;
        case "SPEEDO":
      	  	speedoUser.createNewPasswordOnNewPage(newPassword);
      	  	 break;
        default:
               LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
        }
	}
	
	@Then("^User should successfully login with new password$")
	public void user_should_successfully_login_with_new_password(){
		LOGGER.info("User is verifying new password is valid...");
		
		String brand = Serenity.sessionVariableCalled("brand");
		String email = Serenity.sessionVariableCalled("email");
		String password = Serenity.sessionVariableCalled("newPassword");
		
		switch(brand.toUpperCase()) {
        case "CKUS":
        case "CKCA": 
        	ckUser.navigateTo(brand);
        	ckUser.clickSignIn();
        	ckUser.accountSignIn(email, password);
        	   break;
        case "TH":
        	thUser.accountSignIn(email, password);
               break;
        case "SPEEDO":
        	speedoUser.logOut();
        	speedoUser.navigateTo();
        	speedoUser.clickSignIn();
        	speedoUser.accountSignIn(email, password);
        	break;
        default:
               LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
        }
		
		googleUser.goToInboxAndDeleteAllEmails();
	}
	
	
}
