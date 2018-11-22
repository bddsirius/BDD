package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class EmailTestSteps {

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailTestSteps.class);
	
	@When("^User enters (.*) and submits for newsletter in the pop up$")
	public void user_enters_and_submits_for_newsletter_in_the_pop_up(String email) {
		LOGGER.info("User enters "+email+" and submits for newsletter in the pop up...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.signUpOnPopUp(email);
			break;
		case "TH":
			thUser.signUpOnPopUp(email);
			break;
		case "SPEEDO":
			speedoUser.signUpOnPopUp(email);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies that email successfully registers$")
	public void user_verifies_that_email_successfully_registers() {
		LOGGER.info("User verifies that email successfully registers...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySignUpOnPop();
			break;
		case "TH":
			thUser.verifySignUpOnPop();
			break;
		case "SPEEDO":
			speedoUser.verifySignUpOnPop();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies no email on newsletter pop up error$")
	public void user_verifies_no_email_on_newsletter_pop_up_error() {
		LOGGER.info("User verifies that email successfully registers...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoEmailErrorPopUp();
			break;
		case "TH":
			thUser.verifyNoEmailErrorPopUp();
			break;
		case "SPEEDO":
			speedoUser.verifyNoEmailErrorPopUp();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@When("^User enters no email for newsletter in the pop up$")
	public void user_enters_no_email_and_submits_for_newsletter_in_the_pop_up() {
		LOGGER.info("User enters no email and submits for newsletter in the pop up");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clickSignUpPopUp();
			break;
		case "TH":
			thUser.clickSignUpPopUp();
			break;
		case "SPEEDO":
			speedoUser.clickSignUpPopUp();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Given("^User opens website (.*)$")
	public void user_opens_webstie(String brand) {
		LOGGER.info("User opens website "+brand+"...");
		Serenity.setSessionVariable("brand").to(brand);
		
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateTo(brand);
			break;
		case "TH":
			thUser.openSite();
			break;
		case "SPEEDO":
			speedoUser.openSite();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
		
	}
	
	@When("^User provides email for newsletter on account page$")
	public void user_provides_email_for_newsletter_on_account_page() {
		LOGGER.info("User provides email for newsletter on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterNewLetterAndSubmit();
			break;
		case "TH":
			thUser.enterNewLetterAndSubmit();
			break;
		case "SPEEDO":
			speedoUser.enterNewLetterAndSubmit();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User will verify newsletter sign up$")
	public void user_will_verify_newsletter_sign_up() {
		LOGGER.info("User will verify newsletter sign up...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyEmailNewsLetterSignUpOnAccount();
			break;
		case "TH":
			thUser.verifyEmailNewsLetterSignUpOnAccount();
			break;
		case "SPEEDO":
			speedoUser.verifyEmailNewsLetterSignUpOnAccount();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@When("^User provides invalid email for newsletter on account page$")
	public void user_provides_no_email_for_newsletter_on_account_page() {
		LOGGER.info("User provides no email for newsletter on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterInvalidEmailInNewsLetterAndSubmit();
			break;
		case "TH":
			thUser.enterInvalidEmailInNewsLetterAndSubmit();
			break;
		case "SPEEDO":
			speedoUser.enterInvalidEmailInNewsLetterAndSubmit();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies invalid email with no email on newsletter (.*)$")
	public void user_verifies_invalid_email_with_no_email_on_newsletter(String error) {
		LOGGER.info("User verifies invalid email with no email on newsletter...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoEmailNewsLetterSignUpOnAccount(error);
			break;
		case "TH":
			thUser.verifyNoEmailNewsLetterSignUpOnAccount(error);
			break;
		case "SPEEDO":
			speedoUser.verifyNoEmailNewsLetterSignUpOnAccount(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
}
