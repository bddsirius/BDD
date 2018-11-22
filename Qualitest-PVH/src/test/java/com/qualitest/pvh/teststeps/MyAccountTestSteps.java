package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PaypalActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class MyAccountTestSteps { 
	
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PaypalActor ppUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(MyAccountTestSteps.class);
	
	@And("^User edits personal (.*)$")
	public void user_edits_personal_information(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformation(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformation(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformation(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@And ("^User navigates to checkout preferences$")
	public void user_navigates_to_checkout_preferences() {
	}
	
	@And ("^User navigates my address book$")
	public void user_navigates_to_address_book() {
	}
	
	@Then("^User verifies personal information updated successfully$")
	public void user_verifies_personal_information_updated() {
		LOGGER.info("Verifying personal information updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationUpdated();
			break;
		case "TH":
			thUser.verifyPersonalInformationUpdated();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationUpdated();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	
	@Then("^User verifies error on account page (.*)$")
	public void user_verifies_error_on_account_page(String error) {
		LOGGER.info("User verifies error on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "TH":
			thUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "SPEEDO":
			speedoUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	
	
	
	@And("User edits checkout preferences (.*)$")
	public void user_edits_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editCheckoutInformation(infoFields);
			break;
		case "TH":
			thUser.editCheckoutInformation(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editCheckoutInformation(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@And("User edits billing checkout preferences (.*)$")
	public void user_edits_billing_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editBillingCheckoutInformation(infoFields);
			break;
		case "TH":
			thUser.editBillingCheckoutInformation(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editBillingCheckoutInformation(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@Then("^User verifies checkout preferences updated$")
	public void user_verifies_checkout_preferences_updated() {
		LOGGER.info("Verifying checkout preferences updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCheckoutPreUpdate();
			break;
		case "TH":
			thUser.verifyCheckoutPreUpdate();
			break;
		case "SPEEDO":
			speedoUser.verifyCheckoutPreUpdate();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User adds checkout preferences with (.*)$")
	public void user_adds_checkout_preferences(String information) {
		LOGGER.info("Adding checkout preferences...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationUpdated();
			break;
		case "TH":
			thUser.verifyPersonalInformationUpdated();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationUpdated();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User adds shipping address with valid (.*)$")
	public void user_adds_shipping_address(String values) {
		LOGGER.info("Adding shipping address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addShippingAddress(values);
			break;
		case "TH":
			thUser.addShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.addShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies new address was added$")
	public void user_verifies_new_shipping_address() {
		LOGGER.info("Verifying new address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAddressAdded();
			break;
		case "TH":
			thUser.verifyAddressAdded();
			break;
		case "SPEEDO":
			speedoUser.verifyAddressAdded();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User adds billing address with valid (.*)$")
	public void user_adds_billing_address(String values) {
		LOGGER.info("Adding new billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addBillingAddress(values);
			break;
		case "TH":
			thUser.addBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.addBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User updates billing fields on account page (.*)$")
	public void user_updates_billing_fields_on_account_page(String values) {
		LOGGER.info("User updates billing fields on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.updateBillingAddress(values);
			break;
		case "TH":
			thUser.updateBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.updateBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		} 
	}
	
	
	
	@Then("^User verifies existing billing address has been updated$")
	public void user_verifies_existing_billing_address_has_been_updated() {
		LOGGER.info("User verifies existing billing address has been updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUpdateAddress();
			break;
		case "TH":
			thUser.verifyUpdateAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyUpdateAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		} 
	}
	
	
	
	@And("^User adds shipping and billing address with valid (.*)$")
	public void user_adds_shipping_and_billing_address(String values) {
		LOGGER.info("Adding new shipping and billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addShippingAndBillingAddress(values);
			break;
		case "TH":
			thUser.addShippingAndBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.addShippingAndBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User updates shipping and billing fields (.*)$")
	public void user_updates_shipping_and_billing_fields(String values) {
		LOGGER.info("User updates shipping and billing fields...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.updateBillingAndShippingAddress(values);
			break;
		case "TH":
			thUser.updateBillingAndShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.updateBillingAndShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User inputs shipping and billing (.*) three times")
	public void user_inputs_shipping_and_billing_three_times(String values) {
		LOGGER.info("User inputs shipping and billing three times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.updateBillingAndShippingAddressThreeTimes(values);
			break;
		case "TH":
			thUser.updateBillingAndShippingAddressThreeTimes(values);
			break;
		case "SPEEDO":
			speedoUser.updateBillingAndShippingAddressThreeTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User inputs billing (.*) three times to update$")
	public void user_inputs_billing_info_three_times(String values) {
		LOGGER.info("User inputs billing three times to update...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterUpdateBillingAddressFieldsThreeTimes(values);
			break;
		case "TH":
			thUser.enterUpdateBillingAddressFieldsThreeTimes(values);
			break;
		case "SPEEDO":
			speedoUser.enterUpdateBillingAddressFieldsThreeTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@And("^User inputs shipping data (.*) three times$")
	public void user_inputs_shipping_data_three_times(String values) {
		LOGGER.info("And User inputs shipping data <information> three times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterUpdateShippingAddressFieldsThreeTimes(values);
			break;
		case "TH":
			thUser.enterUpdateShippingAddressFieldsThreeTimes(values);
			break;
		case "SPEEDO":
			speedoUser.enterUpdateShippingAddressFieldsThreeTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	

	@Then("^User verifies updated address with an error on address book$")
	public void user_verifies_updated_address_with_an_error_on_address_book() {
		LOGGER.info("User verifies updated address with an error on address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		case "TH":
			thUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		case "SPEEDO":
			speedoUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds invalid address clicks update three times (.*)$")
	public void user_adds_invalid_address(String values) {
		LOGGER.info("Adding new shipping and billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addInvalidShippingAddress(values);
			break;
		case "TH":
			thUser.addInvalidShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.addInvalidShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
		
		
		
	@And("^User removes an address from address book$")
	public void user_removes_address() {
		LOGGER.info("Removing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.removeSavedAddress();
			break;
		case "TH":
			thUser.removeSavedAddress();
			break;
		case "SPEEDO":
			speedoUser.removeSavedAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies address has been added$")
	public void user_verifies_address_has_been_added() {
		LOGGER.info("Verifying new invalid address added...");
	String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyInvalidAddressAdded();
			break;
		case "TH":
			thUser.verifyInvalidAddressAdded();
			break;
		case "SPEEDO":
			speedoUser.verifyInvalidAddressAdded();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds a new billing address and submits three times (.*)$")
	public void user_adds_a_new_billing_address_and_submits_three_times(String guestInformation) {
		LOGGER.info("And User adds a new billing address and submits three times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterBillingAddressFieldsAndSubmitThreeTimes(guestInformation);
			break;
		case "TH":
			thUser.enterBillingAddressFieldsAndSubmitThreeTimes(guestInformation);
			break;
		case "SPEEDO":
			speedoUser.enterBillingAddressFieldsAndSubmitThreeTimes(guestInformation);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds shipping and billing address and submits three times (.*)$")
	public void user_adds_shipping_and_billing_address_and_submits_three_times(String guestFields) {
		LOGGER.info("User adds shipping and billing address and submits three times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterShipAndBillAddressFieldsThreeTimes(guestFields);
			break;
		case "TH":
			thUser.enterShipAndBillAddressFieldsThreeTimes(guestFields);
			break;
		case "SPEEDO":
			speedoUser.enterShipAndBillAddressFieldsThreeTimes(guestFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds a shipping address but cancels (.*)$")
	public void user_adds_a_shipping_address_but_cancels(String guestFields) {
		LOGGER.info("User adds a shipping address but cancels...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.enterShipAndBillButCancels(guestFields);
			break;
		case "TH":
			thUser.enterShipAndBillButCancels(guestFields);
			break;
		case "SPEEDO":
			speedoUser.enterShipAndBillButCancels(guestFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies that the address worked on is canceled$")
	public void user_verifies_that_the_address_worked_on_is_canceled() {
		LOGGER.info("User verifies that the address worked on is canceled...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCancelAddress();
			break;
		case "TH":
			thUser.verifyCancelAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyCancelAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User deletes all the addresses saved in the address book$")
	public void user_deletes_all_the_addresses_saved_in_the_address_book() {
		LOGGER.info("User deletes all the address saved in the address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.deleteAllAddresses();
			break;
		case "TH":
			thUser.deleteAllAddresses();
			break;
		case "SPEEDO":
			speedoUser.deleteAllAddresses();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies there is only one address in the address book$")
	public void user_verifies_there_is_only_one_address_in_the_address_book() {
		LOGGER.info("User verifies there is only one address in the address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAllAddressesRemoved();
			break;
		case "TH":
			thUser.verifyAllAddressesRemoved();
			break;
		case "SPEEDO":
			speedoUser.verifyAllAddressesRemoved();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@Then("^User verifies address was removed$")
	public void verify_address_removed() {
		LOGGER.info("Verifying address removed...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAddressRemoved();
			break;
		case "TH":
			thUser.verifyAddressRemoved();
			break;
		case "SPEEDO":
			speedoUser.verifyAddressRemoved();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	
	
	
	@Then("^User verifies personal information without address$")
	public void user_verifies_personal_information_without_address() {
		LOGGER.info("Verifying personal information without address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationWithoutAddress();
			break;
		case "TH":
			thUser.verifyPersonalInformationWithoutAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationWithoutAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}	
	
	
	@And("^User updates an address from address book (.*)$")
	public void updates_address_existing(String values) {
		LOGGER.info("Updating existing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.updateSavedAddress(values);
			break;
		case "TH":
			thUser.updateSavedAddress(values);
			break;
		case "SPEEDO":
			//speedoUser.updateSavedAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies personal information with address$")
	public void user_verifies_personal_information_with_address() {
		LOGGER.info("Verifying personal information with address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationAddress();
			break;
		case "TH":
			thUser.verifyPersonalInformationAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User navigates to orders page$")
	public void user_navigates_to_orders_page() {
		LOGGER.info("User navigates to order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMyOrders();
			break;
		case "TH":
			thUser.navigateToMyOrders();
			break;
		case "SPEEDO":
			speedoUser.navigateToMyOrders();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies no orders have been placed$")
	public void user_verifies_no_orders_placed() {
		LOGGER.info("User verifies no orders placed...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoOrders();
			break;
		case "TH":
			thUser.verifyNoOrders();
			break;
		case "SPEEDO":
			speedoUser.verifyNoOrders();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@Then("^User verifies checkout preferences error$")
	public void user_verifies_checkout_preferences_error() {
		LOGGER.info("Verifying checkout preferences error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyErrorMessage();
			break;
		case "TH":
			thUser.verifyErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	
	@Then("^User verifies checkout preferences card error$")
	public void user_verifies_checkout_preferences_card_error() {
		LOGGER.info("Verifying checkout preferences card error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCardErrorMessage();
			break;
		case "TH":
			thUser.verifyCardErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyCardErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@Then("^User verifies checkout preferences empty error$")
	public void user_verifies_checkout_preferences_empty_error() {
		LOGGER.info("Verifying checkout preferences empty error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyEmptyErrorMessage();
			break;
		case "TH":
			thUser.verifyEmptyErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyEmptyErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies personal information field error (.*)$")
	public void user_verifies_personal_information_field_error(String error) {
		LOGGER.info("User verifies personal information field error...");
		String brand = Serenity.sessionVariableCalled("brand");		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		case "TH":
			thUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		case "SPEEDO":
			speedoUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
		
	}
	
	
	@When("^User navigates to rewards tab$")
	public void user_navigates_to_rewards_tab() {
		LOGGER.info("User navigates to rewards tab...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.clickRewardsTabOnAccountPage();
				break;
		
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS");
		}
	}
	
	
	@Then("^User verifies user has no rewards on account page$")
	public void user_verifies_user_has_no_rewards_on_account_page() {
		LOGGER.info("User verifies user has no rewards on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyNoRewardAvailable();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies wishlist is empty$")
	public void user_verifies_empty_wishlist() {
		LOGGER.info("User verifies wishlist is empty...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyEmptyWishlist();
				break;
			case "TH":
				thUser.verifyEmptyWishlist();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User shares wishlist$")
	public void user_shares_wishlist() {
		LOGGER.info("User shares wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.shareWishlist();
				break;
			case "TH":
				thUser.shareWishlist();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies mandatory details not provided error$")
	public void user_verifies_details_not_provided() {
		LOGGER.info("User shares wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyWishlistDetailsNotProvided();
				break;
			case "TH":
				thUser.verifyWishlistDetailsNotProvided();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User provides share wishlist details (.*), (.*), (.*), (.*)$")
	public void user_provides_share_wishlist_details(String toEmail, String name, String fromEmail, String message) {
		LOGGER.info("User enters valid wishlist details...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.enterShareWishlistDetails(toEmail, name, fromEmail, message);
				break;
			case "TH":
				thUser.enterShareWishlistDetails(toEmail, name, fromEmail, message);
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies wishlist was shared$")
	public void user_verifies_wishlist_shared() {
		LOGGER.info("User verifies wishlist shared...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyWishlistShared();
				break;
			case "TH":
				thUser.verifyWishlistShared();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies there are existing orders$")
	public void user_verifies_existing_orders() {
		LOGGER.info("User verifies there are existing orders...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyExistingOrders();
				break;
			case "TH":
				thUser.verifyExistingOrders();
				break;
			case "SPEEDO":
				speedoUser.verifyExistingOrders();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User updates personal (.*) three times$")
	public void user_updates_personal_info_three_times(String infoFields) {
		LOGGER.info("User verifies personal information field error...");
		String brand = Serenity.sessionVariableCalled("brand");		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationAndSubmitThreeTimes(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationThreeTimes(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformationThreeTimes(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	
}

