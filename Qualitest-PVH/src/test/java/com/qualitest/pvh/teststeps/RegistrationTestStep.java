package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class RegistrationTestStep {

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationTestStep.class);

	@And("^User provide (.*) , (.*) and register$")
	public void user_provide_credentials_and_register(String email, String password) {
		LOGGER.info("Starting Registration...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.registerAtSignIn(email, password);
			break;
		case "TH":
			thUser.registerAtSignIn(email, password);
			break;
		case "SPEEDO":
			Serenity.setSessionVariable("speedoEmail").to(email);
			Serenity.setSessionVariable("speedoPassword").to(password);
			speedoUser.clickRegister();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User should be registered successfully without complete details$")
	public void verify_partial_registration_confirmation_page_is_displayed() {
		LOGGER.info("Verifying partial registration confirmation page is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyRegistrationDetailsPageIsDisplayed();
			break;
		case "TH":
			thUser.verifyRegistrationDetailsPageIsDisplayed();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}

	}

	@And("^User provide (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) and save$")
	public void user_provides_full_reg_details_and_saves(String firstName, String lastName, String address,
			String apartment, String city, String country, String state, String zip, String phone, String gender,
			String bMonth, String bDay, String locationCountry, String locationState, String locationStore,
			String communication, String type) {
		
		LOGGER.info("Entering complete registration details...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterRegistrationDetails(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
					bMonth, bDay);
			break;
		case "CKCA":
			ckUser.enterRegistrationDetails(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
					bMonth, bDay);
			break;
		case "TH":
			thUser.enterRegistrationDetails(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
					bMonth, bDay, locationCountry, locationState, locationStore, communication, type);
			break;
		case "SPEEDO":
			String email = Serenity.sessionVariableCalled("speedoEmail");
			String password = Serenity.sessionVariableCalled("speedoPassword");
			speedoUser.enterRegistrationDetails(email, password, firstName, lastName, phone);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}


	@Then("^User should be registered successfully with complete details$")
	public void user_should_be_registered_successfully_with_complete_details() {
		LOGGER.info("Verifying registeration is successfull...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyAccountIsRegistered();
			break;
		case "CKCA":
			ckUser.verifyAccountIsRegistered();
			break;
		case "TH":
			thUser.verifyAccountIsRegistered();
			break;
		case "SPEEDO":
			speedoUser.verifyAccountIsRegistered();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User should see error message on registration page (.*)$")
	public void user_should_get_error_message_on_registration_page(String error) {
		LOGGER.info("Verifying error message...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyErrorMessageOnRegistration(error);
			break;
		case "CKCA":
			ckUser.verifyErrorMessageOnRegistration(error);
			break;
		case "TH":
			thUser.verifyErrorMessageOnRegistration(error);
			break;
		case "SPEEDO":
			speedoUser.verifyErrorMessageOnRegistration(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@When("^User submits invalid address (.*) times$")
	public void user_submits_invalid_address(int noOfTimes) {
		LOGGER.info("Submiting invalid address " + noOfTimes + " times...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.submittingInvalidAddress(noOfTimes-1);
			break;
		case "CKCA":
			ckUser.submittingInvalidAddress(noOfTimes-1);
			break;
		case "TH":
			thUser.submittingInvalidAddress(noOfTimes-1);
			break;
		case "SPEEDO":
			speedoUser.submittingInvalidAddress(noOfTimes-1);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");

		}
	}

	@And("^User add (.*) to cart$")
	public void user_add_product_to_cart(String item) {
		LOGGER.info("Searching for " + item + " and adding it to cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.searchForProductAndAddToCart(item);
			break;
		case "TH":
			thUser.searchForProductAndAddToCart(item);
			break;
		case "SPEEDO":
			speedoUser.searchForProductAndAddToCart(item);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");

		}
	}

	@And("^User provide (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) into shipping information$")
	public void user_provide_shipping_information(String email, String firstName, String lastName, String address,
			String apartment, String city, String state, String country, String zip, String phone) {
		LOGGER.info("Submitting order and entering shipping information...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterAndSubmitOrderAddress(email, firstName, lastName, address, apartment, city, state, zip, phone);
			ckUser.enterShippingAndBilling();
			break;
		case "CKCA":
			ckUser.enterAndSubmitOrderAddressCA(email, firstName, lastName, address, apartment, city, state, zip, phone);
			ckUser.enterShippingAndBillingCA();
			break;
		case "TH":
			thUser.enterAndSubmitOrderAddress(email, firstName, lastName, address, apartment, city, state, country, zip, phone);
			thUser.enterShippingAndBilling();
			break;
		case "SPEEDO":
			speedoUser.enterAndSubmitOrderAddress(email, firstName, lastName, address, apartment, city, state, zip,
					phone);
			speedoUser.enterShippingAndBilling();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@When("^User provide (.*) on checkout page$")
	public void user_provide_credentials_on_checkout_page(String password) {
		LOGGER.info("Entering credentials on checkout page...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterRegistrationOnCheckOut(password);
			ckUser.goToAccount();
			break;
		case "CKCA":
			//ckUser.enterRegistrationOnCheckOut(password);
			//ckUser.goToAccount();
			break;
		case "TH":
			thUser.enterRegistrationOnCheckOut(password);
			thUser.goToAccount();
			break;
		case "SPEEDO":
			speedoUser.enterRegistrationOnCheckOut(password);
			speedoUser.goToAccount();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");

		}

	}

	@Then("^User should be registered successfully$")
	public void user_should_be_registered_successfully() {
		LOGGER.info("Verifying registration is successful...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyLoginIsSuccessful();
			break;
		case "CKCA":
			ckUser.verifyLoginIsSuccessful();
			break;
		case "TH":
			thUser.verifyLoginIsSuccessful();
			break;
		case "SPEEDO":
			speedoUser.verifyLoginIsSuccessful();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}
	
	
}