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

public class CheckoutTestSteps {

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	@Steps
	PaypalActor ppUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(CheckoutTestSteps.class);
	
	@And("^User select shipping method (.*)$")
	public void user_select_shipping_method(String shippingMethod) {
		LOGGER.info("Selecting shipping method...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.selectShippingMethod(shippingMethod);
			break;
		case "TH":
			thUser.selectShippingMethod(shippingMethod);
			break;
		case "SPEEDO":
			speedoUser.selectShippingMethod(shippingMethod);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User submit order using credit card (.*), (.*), (.*), (.*), (.*)$")
	public void user_submit_order_using_credit_card(String type, String number, String code, String expMonth,
			String expYear) {
		LOGGER.info("Submitting order with credit card...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.submitOrderWithCreditCard(type, number, code, expMonth, expYear);
			break;
		case "TH":
			thUser.submitOrderWithCreditCard(type, number, code, expMonth, expYear);
			break;
		case "SPEEDO":
			speedoUser.submitOrderWithCreditCard(type, number, code, expMonth, expYear);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User provides payment information for loyalty (.*), (.*), (.*), (.*), (.*)")
	public void user_provide_card_information_and_submits_order_for_loyalty(String type, String number, String code, String expMonth, String expYear) {
		LOGGER.info("Entering payment information and submitting order for loyaty...");
		String brand = Serenity.sessionVariableCalled("brand");
		Serenity.setSessionVariable("type").to(type);
		LOGGER.info("The card type is: " + type);
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User selects loyalty rewards (.*)$")
	public void user_selects_loyalty_rewards(String amount) {
		LOGGER.info("User selects loyalty rewards...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.applyAward(amount);
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies that a hundred dollar loyalty award is applied$")
	public void user_verifies_that_a_hundred_dollar_loyalty_award_is_applied() {
		LOGGER.info("User verifies that a hundred dollar loyalty award is applied...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verify100LoyaltyApplied();
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies that the award was applied with valid billing information (.*)$")
	public void user_verifies_that_the_award_was_applied_with_valid_billing_information(String reward) {
		LOGGER.info("User verifies that a loyalty award is applied...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyRewardApplied(reward);
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User proceeds to secure checkout$")
	public void user_proceeds_to_secure_checkout() {
		LOGGER.info("Proceeding to secure checkout...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.proceedToSecureCheckout();
			break;
		case "TH":

			thUser.proceedToSecureCheckout();
			break;
		case "SPEEDO":
			speedoUser.proceedToSecureCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@And("^User adds new address (.*) into fields$")
	public void user_adds_new_address(String newAddress) {
		LOGGER.info("Changing and adding a new address...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.changeAndAddAddress(newAddress);
			break;
		case "TH":
			thUser.changeAndAddAddress(newAddress);
			break;
		case "SPEEDO":
			speedoUser.changeAndAddAddress(newAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User verifies that new address has been selected (.*)$")
	public void user_verifies_that_new_address_has_been_selected(String newAddress) {
		LOGGER.info("Verifying that the new address has been added to the addressees...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyNewAddressCurrent(newAddress);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifyNewAddressCurrent(newAddress);
			break;
		case "SPEEDO":
			speedoUser.verifyNewAddressCurrent(newAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@When("^User provides (.*) into address fields$")
	public void user_provides_info_into_address_fields(String guestFields) {
		LOGGER.info("Submitting shipping information...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.startCheckoutAndSubmitAddress(guestFields);
			break;
		case "CKCA":
			ckUser.startCheckoutAndSubmitAddress(guestFields);
			break;
		case "TH":
			thUser.startCheckoutAndSubmitAddress(guestFields);
			break;
		case "SPEEDO":
			speedoUser.startCheckoutAndSubmitAddress(guestFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User verify summary of order submitted using credit card (.*)$")
	public void user_verify_summary_of_order_submitted_using_credit_card(String creditCardType) {
		LOGGER.info("Verifying summary of order submitted using credit card...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyOrderSummary(creditCardType);
			break;
		case "CKCA":
			ckUser.verifyOrderSummary(creditCardType);
			break;
		case "TH":
			thUser.verifyOrderSummary(creditCardType);
			break;
		case "SPEEDO":
			speedoUser.verifyOrderSummary(creditCardType);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verify summary of order submitted using paypal$")
	public void user_verify_order_summary_of_order_submitted_using_paypal() {
		LOGGER.info("Verifying summary of order submitted using paypal...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyOrderSummary("PayPal");
			break;
		case "CKCA":
			break;
		case "TH":
			thUser.verifyOrderSummary("PayPal");
			break;
		case "SPEEDO":
			speedoUser.verifyOrderSummary("PayPal");
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User provides GiftCard information (.*) and (.*)$")
	public void user_provides_giftCard_information(String number, String pin) {
		LOGGER.info("Entering GiftCard information...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterAndApplyGiftCard(number, pin);
			break;
		case "CKCA":
			break;
		case "TH":
			thUser.enterAndApplyGiftCard(number, pin);
			break;
		case "SPEEDO":
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User enters gift card fields (.*), (.*)$")
	public void user_enters_gift_card_fields(String number, String pin) {
		LOGGER.info("Enter GiftCard information...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.justEnterGiftCard(number, pin);
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.justEnterGiftCard(number, pin);
			break;
		case "SPEEDO":
			
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies GiftCard was applied$")
	public void user_verifies_applied_giftCard() {
		LOGGER.info("Verifying GiftCard is applied...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyGiftCardApplied();
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifyGiftCardApplied();
			break;
		case "SPEEDO":

			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User adds new address (.*) into billing fields$")
	public void user_adds_new_billing_address(String newBilling) {
		LOGGER.info("Changing and adding a new billing address...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.changeAndAddBillingAddress(newBilling);
		case "CKCA":

			break;
		case "TH":
			thUser.changeAndAddBillingAddress(newBilling);
			break;
		case "SPEEDO":
			speedoUser.changeAndAddBillingAddress(newBilling);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User verifies that new billing address is selected (.*)$")
	public void user_verifies_that_new_billing_address_is_selected(String newBilling) {
		LOGGER.info("Verifying that the new billing address has been added to the addressees...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyNewBillingAddressCurrent(newBilling);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifyNewBillingAddressCurrent(newBilling);
			break;
		case "SPEEDO":
			speedoUser.verifyNewBillingAddressCurrent(newBilling);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User should verify selecting another shipping address applies to order$")
	public void user_should_verify_selecting_another_shipping_address_applies_to_order() {
		LOGGER.info("Verifying that selecting another shipping address applies to order...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifySecondAddressApplies();
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifySecondAddressApplies();
			break;
		case "SPEEDO":
			speedoUser.verifySecondAddressApplies();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User should verify selecting another billing address applies to order (.*)$")
	public void user_should_verify_selecting_another_billing_address_applies_to_order(String address) {
		LOGGER.info("Verifying that selecting another billing address applies to order...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifySecondBillingAddressApplies(address);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifySecondBillingAddressApplies(address);
			break;
		case "SPEEDO":
			speedoUser.verifySecondBillingAddressApplies(address);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@When("^User edits and adds the address fields (.*)$")
	public void when_user_edits_and_adds_the_address_fields(String editAddress) {
		LOGGER.info("When user edits and adds the address fields...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.editCheckOutAddress(editAddress);
			break;
		case "CKCA":
			ckUser.editCheckOutAddressCKCA(editAddress);
			break;
		case "TH":
			thUser.editCheckOutAddress(editAddress);
			break;
		case "SPEEDO":
			speedoUser.editCheckOutAddress(editAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User verifies the editted address is selected (.*)$")
	public void when_user_verifies_the_editted_address_is_selected(String editAddress) {
		LOGGER.info("User verifies the editted address is selected...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyEditAddressCurrent(editAddress);
			break;
		case "CKCA":
			ckUser.verifyShippingAddressCKCA(editAddress);
			break;
		case "TH":
			thUser.verifyEditAddressCurrent(editAddress);
			break;
		case "SPEEDO":
			speedoUser.verifyEditAddressCurrent(editAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@When("^User edits and adds the billing address fields (.*)$")
	public void user_edits_and_adds_the_billing_address_fields(String editAddress) {
		LOGGER.info("User edits and adds the billing address fields...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.editCheckOutBillingAddress(editAddress);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.editCheckOutBillingAddress(editAddress);
			break;
		case "SPEEDO":
			speedoUser.editCheckOutBillingAddress(editAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User verifies the editted billing address is selected (.*)")
	public void when_user_verifies_the_editted_billing_address_is_selected(String editAddress) {
		LOGGER.info("User verifies the editted billing address is selected...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyEditBillingAddressCurrent(editAddress);
			break;
		case "CKCA":
			ckUser.verifyBillingAddressCKCA(editAddress);
			break;
		case "TH":
			thUser.verifyEditBillingAddressCurrent(editAddress);
			break;
		case "SPEEDO":
			speedoUser.verifyEditBillingAddressCurrent(editAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User goes to check out from cart$")
	public void user_goes_to_check_out() {
		LOGGER.info("User goes to check out...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.goToCheckout();
			break;
		case "CKCA":
			ckUser.goToCheckout();
			break;
		case "TH":
			thUser.goToCheckOut();
			break;
		case "SPEEDO":
			speedoUser.goToCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User adds new address (.*) into billing fields signed in$")
	public void user_adds_new_billing_address_while_signed_in(String newBilling) {
		LOGGER.info("Changing and adding a new billing address while signed in...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.changeAndAddBillingSignedIn(newBilling);
		case "CKCA":

			break;
		case "TH":
			thUser.changeAndAddBillingSignedIn(newBilling);
			break;
		case "SPEEDO":
			speedoUser.changeAndAddBillingSignedIn(newBilling);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User sends editted (.*) and (.*) into CKCA fields")
	public void user_inputs_info_into_shipping_address_fields_in_CKCA(String billingAddress, String shippingAddress) {
		LOGGER.info("User inputting shipping information into shipping fields for CKCA...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKCA":
			ckUser.enterShippingandBillingInformationCKCA(billingAddress, shippingAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User provides Shop Runner account information (.*) , (.*)$")
	public void user_provides_shop_runner_account_information(String shopEmail, String shopPassword) {
		LOGGER.info("User provides shop runner account information...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.enterShopRunnerInfo(shopEmail, shopPassword);
		case "CKCA":
		
			break;
		case "TH":
			thUser.enterShopRunnerInfo(shopEmail, shopPassword);
			break;
		case "SPEEDO":
			speedoUser.enterShopRunnerInfo(shopEmail, shopPassword);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User sends payment information for CKCA")
	public void user_sends_payment_information_for_CKCA() {
		LOGGER.info("User inputting payment info for CKCA...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKCA":
			ckUser.enterTestPaymentInfoCKCA();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User submit order using paypal account (.*) and (.*)$")
	public void user_checkout_using_paypal(String paypalEmail, String paypalPassword) {
		LOGGER.info("Submitting order using paypal account...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.selectPaypalPaymentMethod();
			ppUser.PayWithPaypal(paypalEmail, paypalPassword);
			ckUser.submitCheckoutOrder();
			break;
		case "CKCA":
			break;
		case "TH":
			thUser.selectPaypalPaymentMethod();
			ppUser.PayWithPaypal(paypalEmail, paypalPassword);
			thUser.submitCheckoutOrder();
			break;
		case "SPEEDO":
			speedoUser.selectPaypalPaymentMethod();
			ppUser.PayWithPaypal(paypalEmail, paypalPassword);
			speedoUser.submitCheckoutOrder();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User checkout using Shoprunner (.*) and (.*)$")
	public void user_login__shoprunner(String email, String password) {
		LOGGER.info("Checkout with shoprunner account...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.CheckoutShopRunner(email, password);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.CheckoutShopRunner(email, password);
			break;
		case "SPEEDO":
			speedoUser.loginShopRunner(email, password);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User checkout Shoprunner$")
	public void user_checkout_shoprunner() {
		LOGGER.info("Checkout with shoprunner account...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
		case "CKUS":
			ckUser.checkoutShoprunner();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.checkoutShoprunner();
			break;
		case "SPEEDO":
			speedoUser.checkoutShoprunner();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies order summary page matches purchase and shoprunner")
	public void user_verifies_shoprunner_purchase() {
		LOGGER.info("Verifying order summary matches purchase with shoprunner...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyShopRunner();
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifyShopRunner();
			break;
		case "SPEEDO":

			speedoUser.verifyShopRunner();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies order summary page matches purchase and Shop runner applied$")
	public void user_verifies_order_summary_page_and_shop_runner() {
		LOGGER.info("Verifying order summary matches purchase with shop runner included...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyShopRunnerAndItemDetails();
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	
	}
	
	@And("^User applies giftcard in Shoprunner with giftcard (.*) and (.*)$")
	public void user_applies_giftcard_in_Shoprunner(String number, String pin) {
		LOGGER.info("Applying giftcard in shoprunner window...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.applyGiftCardInShoprunner(number, pin);
			break;
		case "CKCA":
			
			break;
		case "TH":
		
			break;
		case "SPEEDO":
			
		
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies order summary page matches purchase and paypal")
	public void user_verifies_paypal_purchase() {
		LOGGER.info("Verifying order summary matches purchase with paypal...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPaypal();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.verifyPaypal();
			break;
		case "SPEEDO":
			
			speedoUser.verifyPaypal();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User cancels the order$")
	public void user_cancels_order() {
		LOGGER.info("User cancels the order...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.cancelOrder();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.cancelOrder();
			break;
		case "SPEEDO":
			speedoUser.cancelOrder();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User will verify gift card, credit card and loyalty used (.*), (.*)$")
	public void user_will_verify_gift_card_credit_card_and_loyalty(String amount, String creditCardType) {
		LOGGER.info("User will verify gift card, credit card and loyalty used...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyLoyatyandGiftCard(amount, creditCardType);
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	
	@When("^User applies checkout promo code (.*)$")
	public void user_applies_promo_code_in_checkout(String code) {
		LOGGER.info("User applies promo code in checkout");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.goToCheckoutAndApplyPromo(code);
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.goToCheckoutAndApplyPromo(code);
			break;
		case "SPEEDO":
			speedoUser.goToCheckoutAndApplyPromo(code);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
		
	}
	
	@Then("^User verifies that promo code is applied in checkout$")
	public void user_verifies_that_promo_code_is_applied_in_checkout() {
		LOGGER.info("User verifies that promo code is applied in checkout");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPromoCodeAppliedOnCheckout();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.verifyPromoCodeAppliedOnCheckout();
			break;
		case "SPEEDO":
			speedoUser.verifyPromoCodeAppliedOnCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies removing promo code applied$")
	public void user_verifies_removing_promo_code_applied() {
		LOGGER.info("User verifies removing promo code applied...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPromoCodeAppliedAndRemovedOnCheckout();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.verifyPromoCodeAppliedAndRemovedOnCheckout();
			break;
		case "SPEEDO":
			speedoUser.verifyPromoCodeAppliedAndRemovedOnCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies they are on the checkout page$")
	public void user_verifies_they_are_on_the_checkout_page() {
		LOGGER.info("User verifies they are on the checkout page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.verifyTitleOfCheckOutPage();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	
	
	@And("^User edits an item at checkout$")
	public void user_edits_item_at_checkout() {
		LOGGER.info("User editing an item at checkout step...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.editItemAtCheckout();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.editItemAtCheckout();
			break;
		case "SPEEDO":
			speedoUser.editItemAtCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	

	@Then("^User removes and verifies that item is removed$")
	public void user_removes_and_verifies_checkout() {
		LOGGER.info("User editing an item at checkout step...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.removeItemAtCheckout();
			break;
		case "CKCA":
			
			break;
		case "TH":
			thUser.removeItemAtCheckout();
			break;
		case "SPEEDO":
			speedoUser.removeItemAtCheckout();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	

	@Then("^User verifies that the item has been edited$")
	public void user_verifies_edited_item_at_checkout() {
		LOGGER.info("User editing an item at checkout step...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			//String color = Serenity.sessionVariableCalled("item1Color");
			//String size = Serenity.sessionVariableCalled("item1Size");
			//String quant = Serenity.sessionVariableCalled("item1Quant");
			//ckUser.checkColorSizeQuant(color,size,quant);
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@And("^User proceeds to review order page$")
	public void user_proceeds_review_order_page() {
		LOGGER.info("User proceeding to review order step...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.proceedToReviewOrder();
			break;
		case "TH":
			thUser.proceedToReviewOrder();
			break;
		case "SPEEDO":
			speedoUser.proceedToReviewOrder();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	 
	 @Then("^User verifies can navigate back$")
		public void user_verifies_navigation_back() {
			LOGGER.info("User proceeding to review order step...");
			String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.navigateBackAndVerify();
				break;
			case "TH":
				thUser.navigateBackAndVerify();
				break;
			case "SPEEDO":
				speedoUser.navigateBackAndVerify();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
	 
	
	 @Then("^User clicks next$")
		public void user_clicks_next() {
			LOGGER.info("User proceeding to review order step...");
			String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
				
				break;
			case "CKCA":
				ckUser.clickNext();
				break;
			case "TH":
				thUser.clickNext();
				break;
			case "SPEEDO":
				speedoUser.clickNext();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
	 
	 
	 @And("User provides payment information without submitting (.*), (.*), (.*), (.*), (.*)")
		public void user_provide_card_information_without_submit(String type, String number, String code, String expMonth, String expYear) {
			LOGGER.info("Entering payment information and submitting order for loyaty...");
			String brand = Serenity.sessionVariableCalled("brand");
			Serenity.setSessionVariable("type").to(type);
			LOGGER.info("The card type is: " + type);
			switch (brand.toUpperCase()) {
			case "CKUS":
				ckUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
				break;
			case "CKCA":
				
				break;
			case "TH":
				thUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
				break;
			case "SPEEDO":
				speedoUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
	 
	 
	 
	 @Then("^User verifies can edit order$")
		public void user_verifies_able_to_edit_() {
			LOGGER.info("User proceeding to review order step...");
			String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.navigateEditAndVerify();
				break;
			case "TH":
				thUser.navigateEditAndVerify();
				break;
			case "SPEEDO":
				speedoUser.navigateEditAndVerify();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
	 
	 
	 @Then("^User edits product to another size$")
		public void user_edits_product_size() {
			LOGGER.info("User proceeding to review order step...");
			String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.getFirstSize();
				ckUser.clickEditItemFromCartForFirst();
				break;
			case "TH":
				thUser.getFirstSize();
				thUser.clickEditItemFromCartForFirst();
				break;
			case "SPEEDO":
				speedoUser.getFirstSize();
				speedoUser.clickEditItemFromCartForFirst();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
	@And("^User adjusts to (.*) on checkout page$")
	public void user_adjusts_quantity_at_checkout(String quant) {
		LOGGER.info("The user adjusts the quantity to: " + quant+" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.checkoutAndAdjustQuantity(quant);
                 break;
          case "TH":
                 thUser.checkoutAndAdjustQuantity(quant);
                 break;
          case "SPEEDO":
        	  	 speedoUser.checkoutAndAdjustQuantity(quant);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies item quantity is updated$")
	public void user_verifies_quantity_updated() {
		LOGGER.info("Verifying quantity adjusted at checkout...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.verifyAdjustedQuantityOnCheckout();
                 break;
          case "TH":
                 thUser.verifyAdjustedQuantityOnCheckout();
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyAdjustedQuantityOnCheckout();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User enters payment information using credit card (.*), (.*), (.*), (.*), (.*)$")
	public void user_enters_payment_information_using_credit_card(String type, String number, String code, String expMonth, String expYear) {
		LOGGER.info("Entering payment information and going to review order page...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
        	  	 ckUser.goToReviewOrderPage();
                 break;
          case "TH":
                 thUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
                 thUser.goToReviewOrderPage();
                 break;
          case "SPEEDO":
        	  	 speedoUser.enterPaymentInformationButNoSubmit(type, number, code, expMonth, expYear);
        	  	 thUser.goToReviewOrderPage();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds new address (.*) into fields from review order page$")
	public void user_adds_new_address_from_review_order_page(String newAddress) {
		LOGGER.info("Entering payment information and going to review order page...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.changeAndAddressFromReviewOrderPage(newAddress);
                 break;
          case "TH":
                 thUser.changeAndAddressFromReviewOrderPage(newAddress);
                 break;
          case "SPEEDO":
        	  	 speedoUser.changeAndAddressFromReviewOrderPage(newAddress);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User adds new address (.*) into billing fields from review order page$")
	public void user_adds_new_billing_from_review_order_page(String newBilling) {
		LOGGER.info("Entering payment information and going to review order page...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.changeAndAddBillingAddressFromReviewOrderPage(newBilling);
                 break;
          case "TH":
                 thUser.changeAndAddBillingAddressFromReviewOrderPage(newBilling);
                 break;
          case "SPEEDO":
        	  	 speedoUser.changeAndAddBillingAddressFromReviewOrderPage(newBilling);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User edits and add the billing address fields (.*) from review order page$")
	public void user_edits_and_adds_the_billing_address_fields_from_review_order_page(String editAddress) {
		LOGGER.info("User edits and adds the billing address fields from review order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.editCheckOutBillingAddressFromReviewOrderPage(editAddress);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.editCheckOutBillingAddressFromReviewOrderPage(editAddress);
			break;
		case "SPEEDO":
			speedoUser.editCheckOutBillingAddressFromReviewOrderPage(editAddress);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User edits payment information on review order page$")
	public void user_edits_payment_on_review_order_page() {
		LOGGER.info("User navigates to editing payment from review order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.editPaymentOnReviewOrderPage();
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.editPaymentOnReviewOrderPage();
			break;
		case "SPEEDO":
			speedoUser.editPaymentOnReviewOrderPage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies the payment information was updated with (.*), (.*), (.*), (.*)$")
	public void user_verifies_payment_information_updated(String type, String cardNumber, String expMonth, String expYear) {
		LOGGER.info("Verifying the payment information was updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPaymentInformationUpdated(type, cardNumber, expMonth, expYear);
			break;
		case "CKCA":

			break;
		case "TH":
			thUser.verifyPaymentInformationUpdated(type, cardNumber, expMonth, expYear);
			break;
		case "SPEEDO":
			speedoUser.verifyPaymentInformationUpdated(type, cardNumber, expMonth, expYear);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User selects shipping method (.*) from review order page$")
	public void user_select_shipping_method_from_review_order_page(String shippingMethod) {
		LOGGER.info("Selecting shipping method...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editShippingMethodOnReviewOrderPage();
			ckUser.selectShippingMethod(shippingMethod);
			break;
		case "TH":
			thUser.editShippingMethodOnReviewOrderPage();
			thUser.selectShippingMethod(shippingMethod);
			break;
		case "SPEEDO":
			thUser.editShippingMethodOnReviewOrderPage();
			speedoUser.selectShippingMethod(shippingMethod);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies shipping method has been edited to (.*)$")
	public void user_verifies_shipping_method_edited(String shippingMethod) {
		LOGGER.info("Verifying shipping method edited...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyShippingMethodOnReviewOrderPage(shippingMethod);
			break;
		case "TH":
			thUser.verifyShippingMethodOnReviewOrderPage(shippingMethod);
			break;
		case "SPEEDO":
			thUser.verifyShippingMethodOnReviewOrderPage(shippingMethod);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User navigates to Paypal Checkout$")
	public void user_navigates_to_paypal_checkout() {
		LOGGER.info("Navigating to paypal checkout...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
		case "CKUS":
			ckUser.goToPaypalPayment();
			break;
		case "CKCA":
			ckUser.goToPaypalPaymentCKCA();
			break;
		case "TH":
			thUser.goToPaypalPayment();
			break;
		case "SPEEDO":
			speedoUser.goToPaypalPayment();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User pays with Paypal (.*) and (.*)$")
	public void user_pays_with_paypal(String email, String password) {
		LOGGER.info("Paying with paypal account..." + email);
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
		case "CKUS":
			ppUser.PayWithPaypal(email, password);
			ckUser.submitCheckoutOrder();
			break;
		case "CKCA":
			ppUser.PayWithPaypalCKCA(email, password);
			break;
		case "TH":
			ppUser.PayWithPaypal(email, password);
			break;
		case "SPEEDO":
			ppUser.PayWithPaypal(email, password);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
}