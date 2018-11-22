package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class StoreLocatorSteps {

	public static final Logger LOGGER = LoggerFactory.getLogger(StoreLocatorSteps.class);

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@When("^User navigate to store locator$")
	public void user_navigate_to_store_locator() {
		LOGGER.info("Navigating to Store Locator Page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToStoreLocator();
			break;
		case "TH":
			thUser.navigateToStoreLocator();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}
	}

	@Then("^User should see (.*) as pre populated$")
	public void user_should_see_pre_populated_location(String location) {
		LOGGER.info("Verifying pre populated store location...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyDefaultStoreLocation(location);
			break;
		case "TH":
			thUser.verifyDefaultStoreLocation(location);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}
	}

	@When("^User search (.*) on store locator")
	public void user_search_location_on_store_locator(String location) {
		LOGGER.info("Searching store near location: " + location + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.searchStoreNearLocation(location);
			break;
		case "TH":
			thUser.searchStoreNearLocation(location);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}
	}
	
	@Then("^User should see no result (.*)$")
	public void user_should_see_message(String message) {
		LOGGER.info("Verifying no store message...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyErrorMessage(message);
			break;
		case "TH":
			thUser.verifyErrorMessage(message);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}
	}

	@Then("^User should see valid search result for (.*)$")
	public void user_should_see_valid_search_result(String location) {
		LOGGER.info("Verifying store locator search result...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyStoreLocatorResult(location);
			break;
		case "TH":
			thUser.verifyStoreLocatorResult(location);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH");
		}
	}

}